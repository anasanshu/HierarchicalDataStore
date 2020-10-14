import java.util.*;

class UserPresentation implements IUserPresentation{

    private DataRepository dataRepository;

    public UserPresentation(){
        this.dataRepository = new DataRepository();
    }

    public void run(){
        while(true){
           this.displayMenu();
           String result = this.executeUserInput();
           if(result == null) return;
           System.out.println("Result: "+result);
           System.out.println("============================================");
        }
    }

    private void displayMenu(){
        System.out.println("-------------------------------------------");
        System.out.println("Implementing Hierarchical Data Store");
        System.out.println("1. Create a Node");
        System.out.println("2. Update value from a Node");
        System.out.println("3. Delete a Node");
        System.out.println("4. Get data from a Node");
        System.out.println("5. List all direct children of a Node");
        System.out.println("6. Exit");
    }

    private String executeUserInput(){
        Scanner in = new Scanner(System.in);
        String path = "";
        String data = "";
        String message = "";

        switch(in.nextInt()){
            case 1:
                System.out.println("Enter path to create. Example - /root/child/subchild");
                path = in.next();
                System.out.println("Enter data");
                data = in.next();
                if(this.dataRepository.create(path, data)) message = this.nodeCreated();
                else message = this.invalidPath();
                break;
            
            case 2:
                System.out.println("Enter path to update.\nExample - /root/child/subchild");
                path = in.next();
                System.out.println("Enter updated data");
                data = in.next();
                if(this.dataRepository.update(path, data)) message = this.nodeUpdated();
                else message = this.pathDoesNotExists();
                break;

            case 3:
                System.out.println("Enter path to delete.\nExample - /root/child/subchild");
                path = in.next();
                if(this.dataRepository.delete(path)) message = this.nodeDeleted();
                else message = this.pathDoesNotExists();
                break;

            case 4:
                System.out.println("Enter path to get data.\nExample - /root/child/subchild");
                path = in.next();
                message = this.dataRepository.get(path);
                if(message == null) message = this.pathDoesNotExists();
                break;

            case 5:
                System.out.println("Enter path to list children.\nExample - /root/child/subchild");
                path = in.next();
                ArrayList<String> result =  this.dataRepository.list(path);
                message = (result!=null)? String.join(", ", result): this.pathDoesNotExists();
                break;

            case 6:
                message = null;
                break;

            default: 
                System.out.println("Wrong Choice entered");
                break;
        }

        return message;
    }

    private String invalidPath(){
        return "Invalid path entered";
    } 

    private String pathDoesNotExists(){
        return "Entered path doesnot exists";
    }

    private String nodeCreated(){
        return "Node is created";
    }

    private String nodeUpdated(){
        return "Node is updated";
    }

    private String nodeDeleted(){
        return "Node is deleted";
    }


}