import exception.WrongLoginException;
import exception.WrongPasswordException;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String login = scan.next();
        System.out.print("Введите пароль: ");
        String password = scan.next();
        System.out.print("Подтвердите пароль: ");
        String confirmPassword = scan.next();
        try {
            CheckInputData(login, password, confirmPassword);
        } catch (WrongLoginException e) {
            System.out.println("Не верно введен логин!");
        } catch (WrongPasswordException e) {
            System.out.println("Не верно введен пароль!");
        }
    }

    static void CheckInputData(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (!CheckText(login)) {
            throw new WrongLoginException();
        }
        if (!CheckText(password) || !password.equals(confirmPassword)) {
            throw new WrongPasswordException();
        }

    }

    static boolean CheckText(String text) {
        Pattern pattern = Pattern.compile("^[a-zA-Z][a-zA-Z0-9_]{0,20}$");
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }
}