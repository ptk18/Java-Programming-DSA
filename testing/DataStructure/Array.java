package testing.DataStructure;

public class Array {
        int MAX_SIZE = 5;
        int data[] = new int[MAX_SIZE];
        int size = 0;
       
       public String toString(){
        StringBuffer sb = new StringBuffer();
            sb.append("[");
            for(int i=0; i<=size-1; i++){
                sb.append(data[i]);
                sb.append(",");
            }
            sb.append("]");
            return sb.toString();
       }
       public int getAt(int i){
        return data[i];
       }
       public void setAt(int d, int i){
        data[i] = d;
       }
     
}
