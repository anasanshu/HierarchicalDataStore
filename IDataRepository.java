import java.util.*;

interface IDataRepository{
    
    public void create(String path, String data);
    public void update(String path, String data);
    public void delete(String path);
    public String get(String path);
    public ArrayList<HierarchicalDataStore> list(String path);
}