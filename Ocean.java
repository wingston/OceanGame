package ocean;

/**
 *  The Ocean class defines an object that models an ocean full of sharks and
 *  fish.  Descriptions of the methods you must implement appear below.  They
 *  include a constructor of the form
 *
 *      public Ocean(int i, int j, int starveTime);
 *
 *  that creates an empty ocean having width i and height j, in which sharks
 *  starve after starveTime timesteps.
 *
 *  See the README file accompanying this project for additional details.
 */

public class Ocean {

  /**
   *  Do not rename these constants.  WARNING:  if you change the numbers, you
   *  will need to recompile Test4.java.  Failure to do so will give you a very
   *  hard-to-find bug.
   */

  public final static int EMPTY = 0;
  public final static int SHARK = 1;
  public final static int FISH = 2;
  private int[][] bornTime;
  private int starveTime;
  private int width;
  private int height;
  private int[][] ocean;
  
  /**
   *  Define any variables associated with an Ocean object here.  These
   *  variables MUST be private.
   */



  /**
   *  The following methods are required for Part I.
   */

  /**
   *  Ocean() is a constructor that creates an empty ocean having width i and
   *  height j, in which sharks starve after starveTime timesteps.
   *  @param i is the width of the ocean.
   *  @param j is the height of the ocean.
   *  @param starveTime is the number of timesteps sharks survive without food.
   */

  public Ocean(int i, int j, int starveTime) {
    bornTime=new int[width][height];
    width=i;
    height=j;
    ocean = new int[width][height];
    this.starveTime=starveTime;// Your solution here.
  }

  /**
   *  width() returns the width of an Ocean object.
   *  @return the width of the ocean.
   */

  public int width() {
    // Replace the following line with your solution.
    return width;
  }

  /**
   *  height() returns the height of an Ocean object.
   *  @return the height of the ocean.
   */

  public int height() {
    // Replace the following line with your solution.
    return height;
  }

  /**
   *  starveTime() returns the number of timesteps sharks survive without food.
   *  @return the number of timesteps sharks survive without food.
   */

  public int starveTime() {
    // Replace the following line with your solution.
    return starveTime;
  }

  /**
   *  addFish() places a fish in cell (x, y) if the cell is empty.  If the
   *  cell is already occupied, leave the cell as it is.
   *  @param x is the x-coordinate of the cell to place a fish in.
   *  @param y is the y-coordinate of the cell to place a fish in.
   */

  public void addFish(int x, int y) {
	  if(ocean[x][y]==0){
    ocean[x][y]=FISH;// Your solution here.
  }
  }

  /**
   *  addShark() (with two parameters) places a newborn shark in cell (x, y) if
   *  the cell is empty.  A "newborn" shark is equivalent to a shark that has
   *  just eaten.  If the cell is already occupied, leave the cell as it is.
   *  @param x is the x-coordinate of the cell to place a shark in.
   *  @param y is the y-coordinate of the cell to place a shark in.
   */

  public void addShark(int x, int y) {
	  if(ocean[x][y]==0){
	  ocean[x][y]=SHARK;
	  bornTime[x][y]=0;
	  }// Your solution here.
  }

  /**
   *  cellContents() returns EMPTY if cell (x, y) is empty, FISH if it contains
   *  a fish, and SHARK if it contains a shark.
   *  @param x is the x-coordinate of the cell whose contents are queried.
   *  @param y is the y-coordinate of the cell whose contents are queried.
   */

  public int cellContents(int x, int y) {
    if(ocean[x][y]==EMPTY)
    {// Replace the following line with your solution.
    return EMPTY;
  }
    else if(ocean[x][y]==SHARK)
    {
    	return SHARK;
    }
    else
    {
    	return FISH;
    }
  }

  /**
   *  timeStep() performs a simulation timestep as described in README.
   *  @return an ocean representing the elapse of one timestep.
   */
  private int roundwidth(int i)
  {
	  return i%width;
  }
  private int roundheight(int i)
  {
	  return i%height;
  }
  public Ocean timeStep() {
    Ocean next=new Ocean(width,height,starveTime);
    for(int i=0;i<width;i++)
    {
    	for(int j=0;j<height;j++)
    	{
    		if(this.ocean[i][j]==SHARK)
    		{
    			boolean found =false;
    			for(int m=i-1;m<=i+1;m++)
    			{
    				for(int n=j-1;n<=j+1;n++)
    				{
    				    next.bornTime[i][j]=this.bornTime[i][j];
    					if(this.ocean[roundwidth(m)][roundheight(n)]==FISH)
    					{
    						found=true;
    					}
    				}
    				if(found)
    				{
    					next.bornTime[i][j]=0;
    				}
    				else
    				{
    					next.bornTime[i][j]++;
    				}
    				if(this.bornTime[i][j]>starveTime)
    				{
    					next.ocean[i][j]=EMPTY;
    				}
    				else
    				{
    					next.ocean[i][j]=this.ocean[i][j];
    				}
    			}
    			
    		}
    		else if(this.ocean[i][j]==FISH)
    		{
    			int found=0;
    			for(int m=i-1;m<=i+1;m++)
    			{
    				for(int n=j-1;n<=j+1;n++)
    				{
    					next.bornTime[i][j]=this.bornTime[i][j];
    				
    					if(this.ocean[roundwidth(m)][roundheight(n)]==SHARK)
    					{
    						found++;
    					}
    				}
    				if(found==1)
    				{
    					next.ocean[i][j]=EMPTY;
    				}
    				else if(found>1)
    				{
    					next.ocean[i][j]=SHARK;
    					next.bornTime[i][j]=0;
    				}
    				else
    				{
    					next.ocean[i][j]=FISH;
    				}
    					
    				
    		}
    	}
    		else
    		{
    			int foundfish=0;
    			int foundshark=0;
    			for(int m=i-1;m<=i+1;m++)
    			{
    				for(int n=j-1;n<=j+1;n++)
    				{
    					next.bornTime[i][j]=this.bornTime[i][j];
    				
    					if(this.ocean[roundwidth(m)][roundheight(n)]==FISH)
    					{
    						foundfish++;
    					}
    					if(this.ocean[roundwidth(m)][roundheight(n)]==SHARK)
    					{
    						foundshark++;
    					}
    				}
    				if(foundfish<2)
    				{
    					next.ocean[i][j]=EMPTY;
    				}
    				else if(foundfish>=2&&foundshark<=1)
    				{
    					next.ocean[i][j]=FISH;
    				}
    				else
    				{
    					next.ocean[i][j]=SHARK;
    					next.bornTime[i][j]=0;
    				}
    		}
    }
  }
    }
    return next;
  }

  /**
   *  The following method is required for Part II.
   */

  /**
   *  addShark() (with three parameters) places a shark in cell (x, y) if the
   *  cell is empty.  The shark's hunger is represented by the third parameter.
   *  If the cell is already occupied, leave the cell as it is.  You will need
   *  this method to help convert run-length encodings to Oceans.
   *  @param x is the x-coordinate of the cell to place a shark in.
   *  @param y is the y-coordinate of the cell to place a shark in.
   *  @param feeding is an integer that indicates the shark's hunger.  You may
   *         encode it any way you want; for instance, "feeding" may be the
   *         last timestep the shark was fed, or the amount of time that has
   *         passed since the shark was last fed, or the amount of time left
   *         before the shark will starve.  It's up to you, but be consistent.
   */

  public void addShark(int x, int y, int feeding) {
    // Your solution here.
  }

  /**
   *  The following method is required for Part III.
   */

  /**
   *  sharkFeeding() returns an integer that indicates the hunger of the shark
   *  in cell (x, y), using the same "feeding" representation as the parameter
   *  to addShark() described above.  If cell (x, y) does not contain a shark,
   *  then its return value is undefined--that is, anything you want.
   *  Normally, this method should not be called if cell (x, y) does not
   *  contain a shark.  You will need this method to help convert Oceans to
   *  run-length encodings.
   *  @param x is the x-coordinate of the cell whose contents are queried.
   *  @param y is the y-coordinate of the cell whose contents are queried.
   */

  public int sharkFeeding(int x, int y) {
    // Replace the following line with your solution.
    return 0;
  }

}
