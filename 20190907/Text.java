public class Text{
        public static void main(String[] args){
            
        //给定三个 int 变量, 求其中的最大值和最小值. 
        int a=7,b=8,c=2;
        if(a>b){
            if(a>c&&b>c){
                System.out.println("max="+a+",cimax="+b);
            }
            if(a>c&&b<c){
                System.out.println("max="+a+",cimax="+c); 
            }
            if(a<c&&b<c){
                System.out.println("max="+c+",cimax="+a); 
                }           
        }else{
            if(a>c&&b>c){
                System.out.println("max="+b+",cimax="+a);
            }
            if(a>c&&b<c){
                System.out.println("max="+b+",cimax="+c); 
            }
            if(a<c&&b<c){
                System.out.println("max="+c+"cimax="+b); 
                }     
        }    
        // double a=5.0;
        // System.out.println(a);
        //运行结果为0.5
    }
}