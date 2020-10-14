import java.util.*;

class HierarchicalDataStore{
    private ArrayList<HierarchicalDataStore> children;
    private String data;
    private String nodeName;

    public HierarchicalDataStore(String nodeName){
        this.data = "";
        this.nodeName = nodeName;
        this.children = new ArrayList<HierarchicalDataStore>();
    }

    public String getData(){
        return this.data;
    }

    public void setData(String data){
        this.data = data;
    }

    public ArrayList<HierarchicalDataStore> getChildren(){
        return this.children;
    }

    public void setChildren(String child){
        HierarchicalDataStore childNode = new HierarchicalDataStore(child);
        this.children.add(childNode);
    }

    public String getNodeName(){
        return this.nodeName;
    }

    public boolean containsChild(String childNodeName){
        for(HierarchicalDataStore child: this.getChildren()){
            if(childNodeName.equals(child.getNodeName())) return true;
        }

        return false;
    }

    public HierarchicalDataStore getChild(String childNodeName){
        for(HierarchicalDataStore child: this.children){
            if(childNodeName.equals(child.nodeName)) return child;
        }

        return null;
    }
}