interface StoreOperations{

    HierarchicalDataStore head;
    
    void create(String path, String data);
    void update(String path, String data);
    void delete(String path);
    String get(String path);
    ArrayList<HierarchicalDataStore> list(String path);
}