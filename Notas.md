
# Comandos

```bash
# Ver actividad en la app
adb shell dumpsys window | grep -E mCurrentFocus

# Resultado 
# mCurrentFocus=Window{c1f09f9 u0 pe.sura.afpintegraapp/pe.sura.afpintegraapp.MainActivity}
```

```bash
adb devices -l

# Resultado
# List of devices attached
# emulator-5554          device product:sdk_gphone64_x86_64 model:sdk_gphone64_x86_64 device:emulator64_x86_64_arm64 transport_id:1
```

## Appium Inspector config

### Emuladores
```json
{
  "platformName": "Android",
  "appium:platformVersion": "12",
  "appium:deviceName": "Pixel 8 API 33",
  "appium:automationName": "UiAutomator2",
  "appium:appPackage": "pe.sura.afpintegraapp",
  "appium:appActivity": "pe.sura.afpintegraapp.MainActivity",
  "appium:udid": "emulator-5554"
}
```

```json
{
  "platformName": "Android",
  "appium:platformVersion": "12",
  "appium:deviceName": "Pixel 8",
  "appium:app": "C:\\Users\\Smavodev\\Desktop\\Proyectos_Testing\\Appium2_java_maven\\src\\main\\resources\\ApiDemos-debug.apk",
  "appium:automationName": "UiAutomator2"
}
```

### Dispositivo Fisico
```json
{
  "platformName": "Android",
  "appium:platformVersion": "13",
  "appium:deviceName": "Xiaomi M2101K6G",
  "appium:automationName": "UiAutomator2",
  "appium:uuid": "3390e60e",
  "appPackage": "pe.sura.afpintegraapp",
  "appActivity": "pe.sura.afpintegraapp.MainActivity"
}
```

```json
{
  "platformName": "Android",
  "appium:platformVersion": "13",
  "appium:deviceName": "Xiaomi M2101K6G",
  "appium:automationName": "UiAutomator2",
  "appium:uuid": "3390e60e",
  "appium:app": "C:\\Users\\Smavodev\\Desktop\\Proyectos_Testing\\Appium2_java_maven\\src\\main\\resources\\ApiDemos-debug.apk"
}
```