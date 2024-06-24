import 'dart:io';
import 'package:dio/dio.dart';
import 'http_exception.dart';

HttpException parseException(DioException error) {
  switch (error.type) {
    case DioExceptionType.connectionTimeout:
    case DioExceptionType.receiveTimeout:
    case DioExceptionType.sendTimeout:
      return NetWorkException(message: error.message);
    case DioExceptionType.cancel:
      return CancelException(message: error.message);
    case DioExceptionType.badResponse:
      try {
        int? errCode = error.response?.statusCode;
        switch (errCode) {
          case 400:
            return BadRequestException(
                message: 'Bad Request', code: errCode);
          case 401:
            return UnauthorizedException(message: 'Unauthorized Access');
          case 403:
            return BadRequestException(
                message: 'Forbidden Error', code: errCode);
          case 404:
            return BadRequestException(
                message: 'The requested URL was not found on the server', code: errCode);
          case 405:
            return BadRequestException(
                message: 'Method Not Allowed', code: errCode);
          case 406:
            return BadRequestException(message: 'Not Acceptable', code: errCode);
          case 410:
            return BadRequestException(
                message: 'Gone', code: errCode);
          case 422:
            return BadRequestException(
                message: 'Unprocessable Content', code: errCode);
          case 500:
            return BadServiceException(
                message: 'Internal Server Error', code: errCode);
          case 502:
            return BadServiceException(message: 'Bad Gateway', code: errCode);
          case 503:
            return BadServiceException(
                message: 'Service Unavailable', code: errCode);
          case 504:
            return BadServiceException(message: 'Gateway Timeout', code: errCode);
          default:
            return UnknownException(message: 'Don't support HTTP request');
        }
      } on Exception catch (_) {
        return UnknownException(message: error.message);
      }
    case DioExceptionType.unknown:
      if (error.error is SocketException) {
        return NetWorkException(message: error.message);
      } else {
        return UnknownException(message: error.message);
      }
    default:
      return UnknownException(message: error.message);
  }
}
