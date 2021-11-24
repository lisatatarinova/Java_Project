package main.java.menu.dbSideWork;

/**
 * Да просто выпендриваюсь, тип могу свой эксепшн выкинуть :)
 *
 *
 */
public class WrongPassportNumberException extends Exception{
    public String toString(){
        return "Бро, кого ты пытаешься обмануть? Вводи настоящий номер паспорта, и без приколов.";
    }
}
