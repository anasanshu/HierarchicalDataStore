import java.util.*;
class DataRepository implements IDataRepository{

    private ArrayList<HierarchicalDataStore> store;

    public DataRepository(){
        this.store = new ArrayList<HierarchicalDataStore>();
    }

    
    public boolean create(String path, String data){
        String[] nodePath = this.explodePath(path);
        if(nodePath.length == 0) return false;

        int i = 1;
        HierarchicalDataStore head = this.fetchHead(path);
        if(head == null){
            head = new HierarchicalDataStore(nodePath[0]);
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

        return true;
    }

    public boolean update(String path, String data){
        String[] nodePath = this.explodePath(path);
        int i = 1;
        HierarchicalDataStore head = this.fetchHead(path);
        if(head == null) return false;

        while(i<nodePath.length){
            if(!head.containsChild(nodePath[i])) return false;
            head = head.getChild(nodePath[i++]);
        }

        head.setData(data);

        return true;
    }

    public boolean delete(String path){
        String[] nodePath = this.explodePath(path);
        int i = 1;
        HierarchicalDataStore head = this.fetchHead(path);
        if(head == null) return false;

        if(nodePath.length == 1){
            this.store.remove(head);
        }

        while(i<nodePath.length-1){
            if(!head.containsChild(nodePath[i])) return false;
            head = head.getChild(nodePath[i++]);
        }

        for(HierarchicalDataStore child: head.getChildren()){
            if(child.getNodeName().equals(nodePath[i])){
                head.getChildren().remove(child);
            }
        }

        return true;
    }

    public String get(String path){
        String[] nodePath = this.explodePath(path);
        int i = 1;
        HierarchicalDataStore head = this.fetchHead(path);
        if(head == null) return null;

        while(i<nodePath.length){
            if(!head.containsChild(nodePath[i])) return null;
            head = head.getChild(nodePath[i++]);
        }

        return head.getData();
    }

    public ArrayList<String> list(String path){
        ArrayList<String> directChildren = new ArrayList<String>();
        String[] nodePath = this.explodePath(path);
        int i = 1;
        HierarchicalDataStore head = this.fetchHead(path);
        // System.out.println("-------------------------"+head.getNodeName()+"---------------------");
        if(head == null) return null;

        while(i<nodePath.length){
            if(!head.containsChild(nodePath[i])) return null;
            head = head.getChild(nodePath[i++]);
        }

        ArrayList<HierarchicalDataStore> children = head.getChildren();
        for(HierarchicalDataStore child: children){
            directChildren.add(child.getNodeName());
        }

        return directChildren;
    }

    private HierarchicalDataStore fetchHead(String path){
        String[] nodePath = this.explodePath(path);

        for(HierarchicalDataStore rootNode : this.store){
            if(rootNode.getNodeName().equals(nodePath[0])){
                return rootNode;
            }
        }

        return null;
    }

    public ArrayList<HierarchicalDataStore> getStore(){
        return this.store;
    }

    private String[] explodePath(String path){
        String[] nodePath = path.split("/");
        ArrayList<String> list = new ArrayList<String>();
        for(int i=0; i<nodePath.length; i++){
            if(nodePath[i].length()>0) list.add(nodePath[i]);
        }

        return list.toArray(new String[list.size()]);
    }
}