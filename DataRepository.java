import java.util.*;
class DataRepository implements IDataRepository{

    private ArrayList<HierarchicalDataStore> store;

    public DataRepository(){
        this.store = new ArrayList<HierarchicalDataStore>();
    }

    
    public void create(String path, String data){
        String[] nodePath = path.split("/");
        int i = 2;
        HierarchicalDataStore head = this.fetchHead(path);
        if(head == null){
            head = new HierarchicalDataStore(nodePath[1]);
            this.store.add(head);
        }

        while(i<nodePath.length && head.containsChild(nodePath[i])){
            head = head.getChild(nodePath[i]);
            i++;
        }

        for(; i<nodePath.length; i++){
            HierarchicalDataStore child = new HierarchicalDataStore(nodePath[i]);
            (head.getChildren()).add(child);
            head = child;
        }

        head.setData(data);
    }

    public void update(String path, String data){
        String[] nodePath = path.split("/");
        int i = 2;
        HierarchicalDataStore head = this.fetchHead(path);

        while(i<nodePath.length){
            head = head.getChild(nodePath[i++]);
        }

        head.setData(data);
    }

    public void delete(String path){
        String[] nodePath = path.split("/");
        int i = 2;
        HierarchicalDataStore head = this.fetchHead(path);

        if(nodePath.length == 2){
            this.store.remove(head);
        }

        while(i<nodePath.length-1){
            head = head.getChild(nodePath[i++]);
        }

        for(HierarchicalDataStore child : head.getChildren()){
            if(child.getNodeName().equals(nodePath[i])){
                head.getChildren().remove(child);
            }
        }

    }

    public String get(String path){
        String[] nodePath = path.split("/");
        int i = 2;
        HierarchicalDataStore head = this.fetchHead(path);

        while(i<nodePath.length){
            head = head.getChild(nodePath[i++]);
        }

        return head.getData();
    }

    public ArrayList<HierarchicalDataStore> list(String path){
        String[] nodePath = path.split("/");
        int i = 2;
        HierarchicalDataStore head = this.fetchHead(path);

        while(i<nodePath.length){
            head = head.getChild(nodePath[i++]);
        }

        return head.getChildren();
    }

    private HierarchicalDataStore fetchHead(String path){
        String[] nodePath = path.split("/");

        for(HierarchicalDataStore rootNode : this.store){
            if(rootNode.getNodeName().equals(nodePath[1])){
                return rootNode;
            }
        }

        return null;
    }
}