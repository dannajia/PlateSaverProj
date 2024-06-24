import 'package:get_storage/get_storage.dart';

enum StoreKeys { token, firstLogin, userInfo }

class Storage {
  static final Storage _storage = Storage._internal();

  final GetStorage _box = GetStorage();

  GetStorage get box => _box;

  Storage._internal();

  factory Storage() => _storage;

  setToken(String token) => _box.write(StoreKeys.token.toString(), token);

  String? getToken() => _box.read<String>(StoreKeys.token.toString());

  setFirstLogin(bool firstLogin) =>
      _box.write(StoreKeys.firstLogin.toString(), firstLogin);

  bool? getFirstLogin() => _box.read<bool>(StoreKeys.firstLogin.toString());

  setUserInfo(dynamic userInfo) =>
      _box.write(StoreKeys.userInfo.toString(), userInfo);

  dynamic getUserInfo() => _box.read(StoreKeys.userInfo.toString());
}
