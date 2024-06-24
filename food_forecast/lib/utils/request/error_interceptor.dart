// error types
// network error
// client error
// server error

import 'package:dio/dio.dart';
import 'package:food_forecast/utils/request/http_exception.dart';
import 'package:food_forecast/utils/request/parse_exception.dart';

class ErrorInterceptor extends Interceptor {
  ErrorInterceptor();

  @override
  void onError(DioException err, ErrorInterceptorHandler handler) {
    // print('onError: $err');
    // 401 -> refreshToken
    HttpException httpException = parseException(err);
    // 4xx 5xx -> parseException -> log -> db&cache
    // todo send error log request
    handler.resolve(Response(
        requestOptions: err.requestOptions,
        statusCode: httpException.code,
        data: {
          'code': httpException.code,
          'message': httpException.message,
        }));
  }
}