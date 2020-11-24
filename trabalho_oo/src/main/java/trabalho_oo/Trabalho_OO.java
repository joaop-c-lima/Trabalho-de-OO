package trabalho_oo;

import java.util.*;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;

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

        String path = System.getProperty("user.dir") + "/src/main/java/trabalho_oo" + args[0];

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
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        
        String completo = agenda.getRelatorioCompleto();
        System.out.println("==== Relatório Completo ====");
        System.out.println(completo);
        
        String adiados = agenda.getRelatorioAdiados();
        System.out.println("==== Relatório Adiados ====");
        System.out.println(adiados);
        
        String cancelados = agenda.getRelatorioCancelados();
        System.out.println("==== Relatório Cancelados ====");
        System.out.println(cancelados);
        
        String confirmados = agenda.getRelatorioConfirmados();
        System.out.println("==== Relatório Confirmados ====");
        System.out.println(confirmados);

//        //Parametros: identificador, prioridade, data(string), hora(string), duração (dias), nome do evento, local
//        Evento e = new Evento(1, 1, "29/11/2020", "23:06", 4, "Evento1", "Local x");
//
//        //Parametros: identificador, prioridade, data(string), hora(string), duração (minutos), motivo, local
//        Particular p = new Particular(2, 2, "20/11/2020", "02:00", 60, false, "Compromisso particular", "Local y");
//
//        Reuniao r = new Reuniao(3, 2, "23/11/2020", "11:00", 30, "Reunião1", false);
//
//        Aula a = new Aula(4, 1, "23/11/2020", "14:00", 120, "Disciplina1", "Graduação");
//
//        Orientacao o = new Orientacao(5, 1, "23/11/2020", "16:00", 120, "Aluno X", "Mestrado", "Assunto x", false);
//
//        e.imprimeDados();
//        p.imprimeDados();
//        r.imprimeDados();
//        a.imprimeDados();
//        o.imprimeDados();
    }

}
