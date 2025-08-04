import java.util.Scanner;

public class calculator {
    public static  int add(int a,int b){
        return a+b;
    }

    public static  int sub(int a,int b){
        return a-b;
    }

    public static  int mul(int a,int b){
        return a*b;
    }

    public static  int div(int a,int b){
        return a/b;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to Calculator: Enter Data to Calculate :");
        int status=1;
       
        while (status==1) {
        System.out.println("Select the operation to perform: \n1.Add\n2.Subtract\n3.Multiply\n4.Divide\n5.exit");
        int choice;
        System.out.print("Enter choice:");
        choice=sc.nextInt();

        if(choice==5)
          {
            status=0;
            break;
          }

         System.out.println("Enter first value:");
         int a=sc.nextInt();

         System.out.println("Enter second value:");
         int b=sc.nextInt();
         double result;

         switch(choice){
            case 1:System.out.println(a+" + "+b+" = "+add(a,b));
                    break;
            case 2:System.out.println(a+" - "+b+" = "+sub(a,b));
                    break;
            case 3:System.out.println(a+" * "+b+" = "+mul(a,b));
                    break;
            case 4:System.out.println(a+" / "+b+" = "+div(a,b));
                    break;
         }
         
        }
        System.out.println("thanks for using Calculator");
        sc.close();
    } 
}

