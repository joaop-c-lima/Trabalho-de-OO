package trabalho_oo;

import java.util.*;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author Beatriz
 */
public class Trabalho_OO {

    public static void getFileContent(String filePath) throws FileNotFoundException, IOException {

        List<String> content = new ArrayList<>();
        File file = new File(filePath);

        try {

            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {
//            content.add(st);
                System.out.println(st);
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        Agenda agenda = new Agenda();

        String path = args[0];

        File myObj = new File(path);

        try {

            Scanner myReader = new Scanner(myObj);

            boolean lendo_agenda = false;

            while (myReader.hasNextLine()) {

                String data = myReader.nextLine();

                switch (data.charAt(0)) {

                    case 'A':
                        // Lê o identificador
                        String identificador = data.substring(1, 7);

                        // Pula para a próxima linha
                        if (myReader.hasNextLine()) {
                            data = myReader.nextLine();
                        }

                        // Lê data e horário
                        String dataDoCompromisso = data.substring(0, 10);
                        String horario = data.substring(11, 16);

                        // Pula para a próxima linha
                        if (myReader.hasNextLine()) {
                            data = myReader.nextLine();
                        }

                        // Lê duração
                        String duracao = data;

                        // Pula para a próxima linha
                        if (myReader.hasNextLine()) {
                            data = myReader.nextLine();
                        }

                        // Lê nome da disciplina
                        String nomeDaDisciplina = data;

                        // Pula para a próxima linha
                        if (myReader.hasNextLine()) {
                            data = myReader.nextLine();
                        }

                        // Lê nível
                        String nivel = data;

                        // Pula para a próxima linha
                        if (myReader.hasNextLine()) {
                            data = myReader.nextLine();
                        }

                        // Grau de prioridade
                        String grau = data;

                        agenda.addCompromisso(new Aula(Integer.parseInt(identificador), Integer.parseInt(grau), dataDoCompromisso, horario, Integer.parseInt(duracao), nomeDaDisciplina, nivel));

                        // Pula para a próxima linha
                        if (myReader.hasNextLine()) {
                            data = myReader.nextLine();
                        }

                        break;
                    case 'O':
                        // Lê o identificador
                        identificador = data.substring(1, 7);

                        // Pula para a próxima linha
                        if (myReader.hasNextLine()) {
                            data = myReader.nextLine();
                        }

                        // Lê data e horário
                        dataDoCompromisso = data.substring(0, 10);
                        horario = data.substring(11, 16);

                        // Pula para a próxima linha
                        if (myReader.hasNextLine()) {
                            data = myReader.nextLine();
                        }

                        // Lê duração
                        duracao = data;

                        // Pula para a próxima linha
                        if (myReader.hasNextLine()) {
                            data = myReader.nextLine();
                        }

                        // Lê adiavel
                        String adiavel = data;

                        // Pula para a próxima linha
                        if (myReader.hasNextLine()) {
                            data = myReader.nextLine();
                        }

                        // Lê nome do orientador
                        String nomeDoOrientador = data;

                        // Pula para a próxima linha
                        if (myReader.hasNextLine()) {
                            data = myReader.nextLine();
                        }

                        // Lê nível
                        nivel = data;

                        // Pula para a próxima linha
                        if (myReader.hasNextLine()) {
                            data = myReader.nextLine();
                        }

                        // Lê assunto
                        String assunto = data;

                        // Pula para a próxima linha
                        if (myReader.hasNextLine()) {
                            data = myReader.nextLine();
                        }

                        // Grau de prioridade
                        grau = data;

                        agenda.addCompromisso(new Orientacao(Integer.parseInt(identificador), Integer.parseInt(grau), dataDoCompromisso, horario, Integer.parseInt(duracao), nomeDoOrientador, nivel, assunto, adiavel.contains("true")));

                        // Pula para a próxima linha
                        if (myReader.hasNextLine()) {
                            data = myReader.nextLine();
                        }

                        break;
                    case 'R':
                        // Lê o identificador
                        identificador = data.substring(1, 7);

                        // Pula para a próxima linha
                        if (myReader.hasNextLine()) {
                            data = myReader.nextLine();
                        }

                        // Lê data e horário
                        dataDoCompromisso = data.substring(0, 10);
                        horario = data.substring(11, 16);

                        // Pula para a próxima linha
                        if (myReader.hasNextLine()) {
                            data = myReader.nextLine();
                        }

                        // Lê duração
                        duracao = data;

                        // Pula para a próxima linha
                        if (myReader.hasNextLine()) {
                            data = myReader.nextLine();
                        }

                        // Lê adiavel
                        adiavel = data;

                        // Pula para a próxima linha
                        if (myReader.hasNextLine()) {
                            data = myReader.nextLine();
                        }

                        // Lê assunto
                        assunto = data;

                        // Pula para a próxima linha
                        if (myReader.hasNextLine()) {
                            data = myReader.nextLine();
                        }

                        // Grau de prioridade
                        grau = data;

                        agenda.addCompromisso(new Reuniao(Integer.parseInt(identificador), Integer.parseInt(grau), dataDoCompromisso, horario, Integer.parseInt(duracao), assunto, adiavel.contains("true")));

                        // Pula para a próxima linha
                        if (myReader.hasNextLine()) {
                            data = myReader.nextLine();
                        }
                        break;
                    case 'E':
                        // Lê o identificador
                        identificador = data.substring(1, 7);

                        // Pula para a próxima linha
                        if (myReader.hasNextLine()) {
                            data = myReader.nextLine();
                        }

                        // Lê data e horário
                        dataDoCompromisso = data.substring(0, 10);
                        horario = data.substring(11, 16);

                        // Pula para a próxima linha
                        if (myReader.hasNextLine()) {
                            data = myReader.nextLine();
                        }

                        // Lê duração
                        duracao = data;

                        // Pula para a próxima linha
                        if (myReader.hasNextLine()) {
                            data = myReader.nextLine();
                        }

                        // Lê adiavel
                        String nomeDoEvento = data;

                        // Pula para a próxima linha
                        if (myReader.hasNextLine()) {
                            data = myReader.nextLine();
                        }

                        // Lê assunto
                        String localDoEvento = data;

                        // Pula para a próxima linha
                        if (myReader.hasNextLine()) {
                            data = myReader.nextLine();
                        }

                        // Grau de prioridade
                        grau = data;

                        agenda.addCompromisso(new Evento(Integer.parseInt(identificador), Integer.parseInt(grau), dataDoCompromisso, horario, Integer.parseInt(duracao), nomeDoEvento, localDoEvento));

                        // Pula para a próxima linha
                        if (myReader.hasNextLine()) {
                            data = myReader.nextLine();
                        }
                        break;
                    case 'P':
                        // Lê o identificador
                        identificador = data.substring(1, 7);

                        // Pula para a próxima linha
                        if (myReader.hasNextLine()) {
                            data = myReader.nextLine();
                        }

                        // Lê data e horário
                        dataDoCompromisso = data.substring(0, 10);
                        horario = data.substring(11, 16);

                        // Pula para a próxima linha
                        if (myReader.hasNextLine()) {
                            data = myReader.nextLine();
                        }

                        // Lê duração
                        duracao = data;

                        // Pula para a próxima linha
                        if (myReader.hasNextLine()) {
                            data = myReader.nextLine();
                        }

                        // Lê adiavel
                        adiavel = data;

                        // Pula para a próxima linha
                        if (myReader.hasNextLine()) {
                            data = myReader.nextLine();
                        }

                        // Lê assunto
                        String motivo = data;

                        // Pula para a próxima linha
                        if (myReader.hasNextLine()) {
                            data = myReader.nextLine();
                        }

                        // Lê assunto
                        String localDoCompromisso = data;

                        // Pula para a próxima linha
                        if (myReader.hasNextLine()) {
                            data = myReader.nextLine();
                        }

                        // Grau de prioridade
                        grau = data;

                        agenda.addCompromisso(new Particular(Integer.parseInt(identificador), Integer.parseInt(grau), dataDoCompromisso, horario, Integer.parseInt(duracao), adiavel.contains("true"), motivo, localDoCompromisso));

                        // Pula para a próxima linha
                        if (myReader.hasNextLine()) {
                            data = myReader.nextLine();
                        }
                        break;
                    default:
                        break;

                }

            }
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("O correu um erro na leitura dos arquivos");
            e.printStackTrace();
        }

        String completo = agenda.getRelatorioCompleto();
        
        try {
            
            File fileRelatCompleto = new File("relatcompromissos.txt");
            
            FileWriter relatCompromissos = new FileWriter("relatcompromissos.txt");
            
            relatCompromissos.write(completo);
            relatCompromissos.close();
            
        } catch (IOException e) {
            System.out.println("Ocorreu um erro");
            e.printStackTrace();
        }
        

        String adiados = agenda.getRelatorioAdiados();
        
        try {
            
            File fileRelatCompleto = new File("relatadiados.txt");
            
            FileWriter relatAdiados = new FileWriter("relatadiados.txt");
            
            relatAdiados.write(adiados);
            relatAdiados.close();
            
        } catch (IOException e) {
            System.out.println("Ocorreu um erro");
            e.printStackTrace();
        }
        

        String cancelados = agenda.getRelatorioCancelados();
        try {
            
            File fileRelatCancelados = new File("relatcancelados.txt");
            
            FileWriter relatCancelados = new FileWriter("relatcancelados.txt");
            
            relatCancelados.write(cancelados);
            relatCancelados.close();
            
        } catch (IOException e) {
            System.out.println("Ocorreu um erro");
            e.printStackTrace();
        }
        

        String confirmados = agenda.getRelatorioConfirmados();
        try {
            
            File fileRelatConfirmados = new File("relatconfirmados.txt");
            
            FileWriter relatConfirmados = new FileWriter("relatconfirmados.txt");
            
            relatConfirmados.write(confirmados);
            relatConfirmados.close();
            
        } catch (IOException e) {
            System.out.println("Ocorreu um erro");
            e.printStackTrace();
        }

    }

}
