import 'package:dio/dio.dart';
import 'package:get/get.dart' as GetX;
import '../../pages/login/view.dart';
import '../storage.dart';
import 'base_entity.dart';
import 'base_list_entity.dart';
import 'config.dart';
import 'error_interceptor.dart';

class DioHttp {
  final Dio _client = Dio();

  Dio get client => _client;

  static final DioHttp _instance = DioHttp._internal();

  factory DioHttp() => _instance;

  CancelToken _cancelToken = CancelToken();

  DioHttp._internal() {
    _client.options = _client.options.copyWith(
      baseUrl: Config.baseUrl,
      connectTimeout: const Duration(seconds: 20),
      receiveTimeout: const Duration(seconds: 30),
    );
    _client.interceptors.addAll([
      ErrorInterceptor(),
      if (Config.env == Env.Dev) LogInterceptor(responseBody: true),
    ]);
  }

  // cancel request
  void cancelRequests({CancelToken? cancelToken}) {
    cancelToken ?? _cancelToken.cancel('Request Canceled');
    cancelToken?.cancel('Request Canceled');
  }

  void init({
    String? baseUrl,
    Duration? connectTimeout,
    Duration? receiveTimeout,
    List<Interceptor>? interceptors,
  }) {
    _client.options = _client.options.copyWith(
      baseUrl: baseUrl,
      connectTimeout: connectTimeout,
      receiveTimeout: receiveTimeout,
    );
    _client.interceptors.addAll(interceptors!);
  }

  // RESTful -> get post delete put
  // axios -> axios.get(path, params, {headers})
  Future<BaseEntity> get(
    String path, {
    Map<String, dynamic>? params,
    bool? needToken = true,
    CancelToken? cancelToken,
  }) async {
    final headers = {'accept': '*/*'};
    if (needToken!) {
      String? token = Storage().getToken();
      headers['Authorization'] = token!;
    }

    Response response = await _client.get(
      path,
      queryParameters: params,
      options: Options(headers: headers),
      cancelToken: cancelToken ?? _cancelToken,
    );
    BaseEntity entity = BaseEntity.fromJson(response.data);
    _checkState(entity.code);
    return entity;
  }

  Future<BaseListEntity> getList(
    String path, {
    Map<String, dynamic>? params,
    bool? needToken = true,
    CancelToken? cancelToken,
  }) async {
    final headers = {'accept': '*/*'};
    if (needToken!) {
      String? token = Storage().getToken();
      headers['Authorization'] = token!;
    }

    Response response = await _client.get(
      path,
      queryParameters: params,
      options: Options(headers: headers),
      cancelToken: cancelToken ?? _cancelToken,
    );
    int code = response.data['code'];
    if (code == 200){
      BaseListEntity entity = BaseListEntity.fromJson(response.data);
      return entity;
    } else {
      _checkState(code);
    }
    return BaseListEntity(code: code, msg: "system is abnormal", rows: [], total: 0);
  }

  Future<BaseEntity> post(
    String path, {
    Map<String, dynamic>? params,
    bool? needToken = true,
    CancelToken? cancelToken,
  }) async {
    final headers = {'accept': '*/*'};
    if (needToken!) {
      String? token = Storage().getToken();
      headers['Authorization'] = token!;
    }

    Response response = await _client.post(
      path,
      data: params,
      options: Options(headers: headers),
      cancelToken: cancelToken ?? _cancelToken,
    );
    BaseEntity entity = BaseEntity.fromJson(response.data);
    _checkState(entity.code);
    return entity;
  }

  Future<BaseEntity> delete(
    String path, {
    Map<String, dynamic>? params,
    bool? needToken = true,
    CancelToken? cancelToken,
  }) async {
    final headers = {'accept': '*/*'};
    if (needToken!) {
      String? token = Storage().getToken();
      headers['Authorization'] = token!;
    }

    Response response = await _client.delete(
      path,
      data: params,
      options: Options(headers: headers),
      cancelToken: cancelToken ?? _cancelToken,
    );
    int code = response.data['code'];
    if (code == 200) {
      BaseEntity entity = BaseEntity.fromJson(response.data);
      return entity;
    } else {
      _checkState(code);
    }
    return BaseEntity(code: code, msg: "system is abnormal", data: "");
  }

  Future<BaseEntity> put(
    String path, {
    Map<String, dynamic>? params,
    bool? needToken = true,
    CancelToken? cancelToken,
  }) async {
    final headers = {'accept': '*/*'};
    if (needToken!) {
      String? token = Storage().getToken();
      headers['Authorization'] = token!;
    }
    Response response = await _client.put(
      path,
      data: params,
      options: Options(headers: headers),
      cancelToken: cancelToken ?? _cancelToken,
    );
    BaseEntity entity = BaseEntity.fromJson(response.data);
    _checkState(entity.code);
    return entity;
  }

  _checkState(int code) {
    switch (code) {
      case 401:
        String? token = Storage().getToken();

        if (token != null || token!.isNotEmpty) {
          Storage().setToken("");
          GetX.Get.offAll(const LoginPage());
        }
        break;
    }
  }
}
