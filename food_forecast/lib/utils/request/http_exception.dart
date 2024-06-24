// exception class -> HttpException
class HttpException implements Exception {
  final String? _message;
  final int? _code;

  // the first param -> message
  // the second param -> message code
  HttpException([this._message, this._code]);

  String get message => _message ?? runtimeType.toString();
  int get code => _code ?? -1;
}

class BadRequestException extends HttpException {
  
  // message and code can be null value
  BadRequestException({String? message, int? code}) : super(message, code);
}

class BadServiceException extends HttpException {
  BadServiceException({String? message, int? code}) : super(message, code);
}

class UnknownException extends HttpException {
  UnknownException({String? message}) : super(message);
}

class CancelException extends HttpException {
  CancelException({String? message}) : super(message);
}

class NetWorkException extends HttpException {
  NetWorkException({String? message, int? code}) : super(message, code);
}

class UnauthorizedException extends HttpException {
  UnauthorizedException({String? message}) : super(message, 401);
}

class BadResponseException extends HttpException {
  BadResponseException({String? message, int? code}) : super(message, code);
}