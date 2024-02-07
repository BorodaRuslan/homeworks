package org.example.home_work5.repository;

import org.example.home_work5.entity.AccountDTO;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class AccountRepo {
    private static final String FILE_PATH = "src/main/resources/data.csv";

    public List<AccountDTO> getAccounts(){
        List<AccountDTO> result = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH))){
            // Пропускаем первую строку с именами столбцов
            bufferedReader.readLine();
            String line;

            while ((line = bufferedReader.readLine()) != null){
                String[] arrFields = line.split(",");
                AccountDTO accountDTO = createAccountDTO(arrFields);

                result.add(accountDTO);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public String creatAccount(AccountDTO account) throws FileNotFoundException {

        // Делаем проверку на уникальность id
        long accountID = account.getId();
        boolean idExists = getAccounts().stream().anyMatch(a -> a.getId() == accountID);

        if (idExists){
            return "Account with id " + accountID + " already exists. Cannot insert duplicate id.";
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_PATH, true))){
            // Преобразование объекта AccountDTO в строку и запись в файл
            String accountLine = createAccountLine(account);
            bufferedWriter.write(accountLine);
            bufferedWriter.newLine();

        } catch (IOException e){
            throw new RuntimeException(e);
        }

        return "Recording was successful!";
    }

    public String updateAccount(long idAccount, AccountDTO newData) throws IOException {
        List<String> updates = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH))) {
            // Пропускаем первую строку с именами столбцов
            bufferedReader.readLine();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] arrFields = line.split(",");
                long id = Long.parseLong(arrFields[0].trim());

                if (id == idAccount) {
                    // Найдена запись для обновления
                    // Добавляем обновленную
                    updates.add(createAccountLine(newData));
                } else {
                    // Оставляем остальные строки без изменений
                    updates.add(line);
                }
            }
        } catch (FileNotFoundException e) {
            return "Error updating account: " + e.getMessage();
        } catch (IOException e) {
            return "Error updating account: " + e.getMessage();
        }

        // Записываем изменения
        String tempFilePath = "src/main/resources/tempData.csv";
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tempFilePath))){
            for (String line: updates){
                bufferedWriter.write(line);
                // Каждая запись начинается с новой строки
                bufferedWriter.newLine();
            }
        } catch (IOException e){
            throw new RuntimeException(e);
        }
        // Заменяем исходный файл временным
        Path sourcePath = Paths.get(tempFilePath);
        Path destinationPath = Paths.get(FILE_PATH);
        try {
            Files.move(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
            return "Account updated successfully!";
        } catch (IOException e){
            return "Error updating account: " + e.getMessage();
        }

    }

    public String deleteAccount(long idAccount){
        List<String> remainingLines = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH))){
            bufferedReader.readLine();

            String line;
            while ((line = bufferedReader.readLine()) != null){
                String[] arrFields = line.split(",");
                long id = Long.parseLong(arrFields[0].trim());

                if (id != idAccount){
                    // Добавляем строки, которые не соответствуют удаляемому id
                    remainingLines.add(line);
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Записываем оставшиеся строки в файл
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_PATH))){
            for (String remainingLine : remainingLines) {
                bufferedWriter.write(remainingLine);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return "Account with id " + idAccount + "successfully removed!";
    }

    private String createAccountLine(AccountDTO account) {
        return String.format("%d,%s,%s,%s,%s,%.2f,%s",
                account.getId(), account.getFirstName(), account.getLastName(),
                account.getCountry(), account.getBirthday(),
                account.getBalance(), account.getGender());
    }

    private AccountDTO createAccountDTO(String [] arrFields){
        long id = Long.parseLong(arrFields[0].trim());
        String firstName = arrFields[1].trim();
        String lastName =arrFields[2].trim();
        String country = arrFields[3].trim();
        String birthday = arrFields[4].trim();
        double balance = Double.parseDouble(arrFields[5].trim());
        String gender = arrFields[6].trim();

        return new AccountDTO(id, firstName, lastName, country, birthday, balance, gender);
    }


}
