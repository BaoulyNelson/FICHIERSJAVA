class Tableau5{
	public static void main(String a[]){
		int tb[][]=new int[3][4];
		System.out.println(tb.length);
		System.out.println(tb[0].length);
		System.out.println(tb.length*tb[0].length);
		 
		int tb2[][]={
			        {3,3332,23},
					{32,0,6,3,0},
					{30,221,8,1111,13,8}
		            };
				
	System.out.println(tb2.length);
		System.out.println("----------------------");
		
	for(int i=0;i<tb2.length;i++){
		for(int j=0;j<tb2[i].length;j++){
			System.out.println(tb2[i][j]);
		}
		System.out.println("");
	}
	
	}
}