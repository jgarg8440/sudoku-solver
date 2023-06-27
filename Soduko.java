class Soduko{
    public static boolean issafe(int s[][],int row,int col,int digit){
    //colume
   for(int i=0;i<=8;i++){
    if(s[i][col]==digit){
        return false;
    }
}
    //row
    for(int j=0;j<=8;j++){
        if(s[row][j]==digit){
             return false;
        }
    }
     //grid
     int sr = (row/3)*3;
     int sc = (col/3)*3;
     for(int i=sr;i<sr+3;i++){
        for(int j=sc;j<sc+3;j++ )
        {
            if(s[i][j]==digit){
            return false;
            }
        }
     }
     return true;
    }
    public static boolean soduku(int s[][],int row,int col){
        //base case
        if(row==9 ){
            return true;
        }

        //recursion
        int nextrow = row; 
        int nextcol = col+1;
        if(col+1 == 9){
            nextrow = row+1;
            nextcol =0;
        }
        if(s[row][col]!=0){
            return soduku(s , nextrow ,nextcol);
        }
        for(int digit = 1; digit<=9; digit++){
     if(issafe(s,row,col,digit)){
        s[row][col]= digit;
        if(soduku(s, nextrow, nextcol)){
            return true;
         }
         s[row][col] = 0;
       }
    }
    return false;
 }
 public static void print(int s[][]){
    for(int i=0;i<9;i++){
         for(int j=0;j<9;j++){
            System.out.print(s[i][j]+" ");
         }
         System.out.println();
    }
 }
    public static void main(String args[]){
        int s[][] = 
        {{0,0,8,0,0,0,0,0,0},
        {4,9,0,1,5,7,0,0,2},
        {0,0,3,0,0,4,1,9,0},
        {1,8,5,0,6,0,0,2,0},
        {0,0,0,0,2,0,0,6,0},
        {9,6,0,4,0,5,3,0,0},
        {0,3,0,0,7,2,0,0,4},
        {0,4,9,0,3,0,0,5,7},
        {8,2,7,0,0,9,0,1,3}};
        if(soduku(s,0,0)){
            System.out.println("Solution exist");
            print(s);
        }
        else{
            System.out.println("Solution does not exist");
        }
    }
}