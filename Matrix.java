
public class Matrix{
    private int rows;
    private int columns;
    private int[][] array;
    //Constructor method, intializes all elements to 0
    public Matrix(int row, int col){
        if(row<=0 && col<=0){
            this.rows=3;
            this.columns=3;
            array=new int[rows][columns];
            for(int i=0;i<rows;i++){
            	for(int j=0;j<columns;j++){
            		array[i][j]=0;
            }
        }
        }
        else if(row<=0){
            this.rows=3;
            this.columns=col;
            array=new int[rows][columns];
            for(int i=0;i<rows;i++){
            	for(int j=0;j<columns;j++){
            		array[i][j]=0;
            }
        }
        }
        else if(col<=0){
            this.rows=row;
            this.columns=3;
            array=new int[rows][columns];
            for(int i=0;i<rows;i++){
            	for(int j=0;j<columns;j++){
            		array[i][j]=0;
            }
        }
            
        }
        else{
            this.rows=row;
            this.columns=col; 
            array=new int[rows][columns];
            for(int i=0;i<rows;i++){
            	for(int j=0;j<columns;j++){
            		array[i][j]=0;
            }
        }
            }
    }
    //Second constructor class, uses 2-D arrays to construct matrices (i.e. table[0][0] would be the element in the first element in the first
    //row of the array
    
    public Matrix(int[][] table){
    	this.rows=table.length;
    	this.columns=table[0].length; 
    	array=new int[rows][columns];
    	for(int i=0;i<this.rows;i++){
    		for(int j=0;j<this.columns;j++){
    			array[i][j]=table[i][j];
    		}
    	}
    }
    //returns number of rows in the matrix
    public int getRows(){
    	return (this.rows);
    }
    //returns number of columns in the matrix
    public int getColumns(){
    	return(this.columns);
    }
    //returns element in row 'i' and column 'j' in the matrix. Out of bound indexes are invalid.
    public int getElement(int i, int j) throws IndexOutOfBoundsException{
    	if(i<rows&&j<columns&&i>=0&&j>=0){
    		return(this.array[i][j]);
    	}
    	else{
    		throw new IndexOutOfBoundsException("invalid entry! ");
    	}
    }
    //sets element in row 'i' and column 'j' to integer value x
    public boolean setElement(int x, int i, int j){
    	if(i<rows&&j<columns&&i>=0&&j>=0){
    		array[i][j]=x;
    		return(true);
    	}
    	else{
    		return(false);
    	}
    	
    }
    
    //returns a deep copy of this matrix
    public Matrix copy(){
    	int[][] matcopy=new int[rows][columns];
    	for(int i=0;i<this.rows;i++){
    		for(int j=0;j<this.columns;j++){
    			matcopy[i][j]=array[i][j];
    			
    		}
    		}
    	Matrix matcop=new Matrix(matcopy);
    	return(matcop);
    }
    
    //adds values of Matrix 'm' to this matrix; changes this matrix's values
    public void addTo(Matrix m) throws ArithmeticException{
    	if(this.rows==m.rows && this.columns==m.columns){
    		for(int i=0;i<this.rows;i++){
        		for(int j=0;j<this.columns;j++){
        			this.array[i][j]=this.array[i][j]+m.array[i][j];
        		}
    	}
    		}
    	else{
    		throw new ArithmeticException("Invalid Operation!");
    	}
    	
    }
    
    //returns a subcopy of this matrix
    public Matrix subMatrix(int i, int j) throws ArithmeticException{
    	int[][] subcopy=new int[i][j];
    	if(i<rows&&j<columns&&i>=0&&j>=0){
			for(int x=0;x<i;x++){
				for(int y=0;y<j;y++){
					subcopy[x][y]=this.array[x][y];
    		}
    		}
    	}
    	else{
    		throw new ArithmeticException("Invalid Operation!");
    	}
		Matrix subcop=new Matrix(subcopy);
    	return(subcop);
    }
    
    //checks if this matrix is an upper triangular matrix
    public boolean isUpperTr(){
    	for(int i=this.rows-1;i>=0;i--){
    		for(int j=this.columns-1;j>=0;j--){
    			if(j<i && this.array[i][j]!=0){
    				return (false);
    			}
    		}
    }
    	return(true);
    }
    
    //static method which equates matrix class to sum of all matrices in Matrix[]
    public static Matrix sum(Matrix[] matArray) throws ArithmeticException{
    	for(int i=1;i<matArray.length;i++){
    		if(matArray[0].rows==matArray[i].rows && matArray[0].columns==matArray[i].columns){
    				matArray[0].addTo(matArray[i]);
    	}
    		else{
    			throw new ArithmeticException("Invalid Operation!");
    		}
    	
    }
    	return(matArray[0]);
    }
    
    //outputs the matrix in the readable matrix format
    public String toString(){
    	String rowPrint=new String(); 
 	   	for(int i=0;i<this.rows;i++){
    		for(int j=0;j<this.columns;j++){
    			rowPrint+=this.array[i][j]+"  ";
    		}
    		rowPrint+="\n";
    }
 	   	return(rowPrint);
    }
 


public static void main(String[] args) {
	
}
}
