import java.util.Scanner;

/**
 * Factory class to start five threads.  
 *
 */
public class Factory
{
   public static void main(String args[]) {
   //get user input of memory size and frame size, calculate the number of frames in memory
   
	   Scanner keyboard = new Scanner(System.in);
	   int memorySize, frameSize, numFrames;
	   
	   // Test case = 1024
	   System.out.println("Please enter memory size.");
	   memorySize = keyboard.nextInt();
	   // Test case = 4
	   System.out.println("Please enter the frame size.");
	   frameSize = keyboard.nextInt();
	   
	   numFrames = (int) memorySize / frameSize;
	   
  
	   //construct physical memory and pass the number of frames as a parameter
      PhysicalMemory physicalMemory = new PhysicalMemory(numFrames);
      Thread[] threadArray = new Thread[5];
   
      for(int i=0; i<5 ;i++)
         threadArray[i] = new Thread(new MemoryThread(physicalMemory, i));
      for(int i=0; i<5; i++)
         threadArray[i].start();
   }
}
