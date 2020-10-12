class HierarchicalDataStore{
    // private ArrayList<HierarchicalDataStore> children;
    // private String data;
    // private String nodeName;

    private ArrayList<Set<String>> nodes;
    private Map<String, String> map;

    public HierarchicalDataStore(String nodeName){
        // this.children.add(child);
        // this.data = data;
        this.nodeName = nodeName;
    }

    public String getData(String nodeName){
        return this.map.get(nodeName);
    }

    public void setData(String nodeName, String data){
        this.map.put(nodeName, data);
    }

    public Set<String> getChildren(String nodeName){
        return this.nodes.get(nodeName);
    }

    public void setChildren(String nodeName, String child){
        (this.nodes.get(nodeName)).add(child);
    }
}