import java.io.*;
import java.util.Scanner;

public class NotesApp {
    private static final String file_name="notes.txt";

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n=== Notes App ===");
            System.out.println("1. Write a new note");
            System.out.println("2. View all notes");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    writeNote(sc);
                    break;
                case 2:
                    readNote();
                    break;
                case 3:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 3);

        sc.close();
    }

    private static void writeNote(Scanner sc){
        System.out.println("Enter your note: ");
        String note=sc.nextLine();

        try(FileWriter fw=new FileWriter(file_name,true)){
            fw.write(note+System.lineSeparator());
            System.out.println("Note Saved successfully");
        }catch (IOException e){
            System.out.println("Error writing to file:"+e.getMessage());
        }
    }

    private static void readNote(){
        File file=new File(file_name);
        if(!file.exists()){
            System.out.println("No file found");
            return;
        }

        try(BufferedReader br=new BufferedReader(new FileReader(file))){
            String line;
            System.out.println("your notes ................/ :");
            while((line= br.readLine())!=null){
                System.out.print(line);
            }
        }
        catch (IOException e){
            System.out.println("Error reading :"+e.getMessage());
        }

    }
}
