import java.util.concurrent.Semaphore;

public class PhysicalMemory 
{

	int freeFrameCount, numFrames;
	boolean[] memoryAllocationMap;
	PageTableList pl;
	Semaphore mutex;

	/* constructor */
	public PhysicalMemory(int numofFrames)
	{
		this.numFrames = numofFrames;
		this.memoryAllocationMap = new boolean[numofFrames];
		this.freeFrameCount = numofFrames;
		this.pl = new PageTableList();
		this.mutex = new Semaphore(1);

		for(int i = 0; i < memoryAllocationMap.length; i++)
		{
			memoryAllocationMap[i] = false;
		}
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
		try {
			mutex.acquire();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if(requestLength > freeFrameCount)
		{
			try {
				mutex.release();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		
		PageTable pt = new PageTable(id, requestLength);
		
		int idx = 0;
		while(this.memoryAllocationMap[idx] == true)
		{
			idx++;
		}
		
		for(; idx < this.memoryAllocationMap.length; idx++)
		{
			memoryAllocationMap[idx] = true;
			pt.appendEntry(idx);
		}
		
		pl.addFirst(pt);
		
		this.freeFrameCount -= requestLength;

		try {
			mutex.release();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}

	/* Convert logical page number to physical frame number. 
	 * @param id the threadID of the requesting thread
		@param pageNumber the page number the thread wants to access 
		@return the frameNumber (physical address) of the pageNumber (logical address)
	 */
	public int accessMemory(int id, int pageNumber)
	{ 
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
