@echo off

cd %~dp0
for /f "tokens=1,2 delims==" %%i in (my_config.ini) do (
	set %%i=%%j
)
start "just_autofill_service" javaw -jar just_autofill.jar %justacc% %justpwd%
