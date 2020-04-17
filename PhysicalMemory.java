
public class PhysicalMemory 
{
	int numOfFrames;
	Object[] memArray;
	
	/* constructor */
	public PhysicalMemory(int numofFrames)
	{
		this.numOfFrames = numofFrames;
		this.memArray = new Object[numOfFrames];
	}
	
	/* If the memory has enough free frames to serve the memory request from a thread, 
	 * allocate the free frames to the thread, build the thread’s page table, and update 
	 * free frames state
		@param id the threadID of the requesting thread
		@param requestLength the number of pages the thread requests
		@return If the request can be served (which means the free
		frames in memory is greater or equal to the requestLength), return true
		else return false
	*/
	
	public boolean requestMemory(int id, int requestLength)
	{
		// TODO
		return true;
	}
	
	/* Convert logical page number to physical frame number. 
	 * @param id the threadID of the requesting thread
		@param pageNumber the page number the thread wants to access 
		@return the frameNumber (physical address) of the pageNumber (logical address)
	*/
	public int accessMemory(int id, int pageNumber)
	{
		// TODO
		return 0;
	}
	
	/* Set the frames allocated to the calling thread to free 
	 * @param id the threadID of the calling thread
	*/
	public void releaseMemory(int id)
	{
		// TODO
	}
	
	
	
	

}
