package core.launcher;

public class DriverNotFoundException extends Exception {
    public DriverNotFoundException(String nameOfDriver) {
        super(
                String.format(
                        "%s not supported, please check env variables or resources/settings.yml",
                        nameOfDriver
                )
        );
    }
}
