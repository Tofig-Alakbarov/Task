package Tofig;


import java.util.List;

// So here I create generic class which can work on any type of data type
public class PaginationHelper <T> {
	// I create private variables so it can't be accessed and changed outside of this class
  private int itemsCount, pagesCount, itemsPerPage;
  
/* I create below parameterized constructor so when I create object I will pass list of values 
  and an integer indicating how many items will be allowed per each page 
  */
  public PaginationHelper(List<T> list, int itemsPerPage) {
	  // Here I initialize items count which is size of passed list.
    itemsCount = list.size();
    /* Here I initialize pages count with ternary operator. So when condition is true first condition which is 
     * "itemsCount / itemsPerPage" will get executed
     * otherwise itemsCount / itemsPerPage + 1 will get executed
     * because for example lets say 8 items and 4 items per page it will be just 8/2=4
     * if condition is not true then result will be rounded down so we need add 1 for modulo part of result 
     * which is always going to be be less than items per page
     */
    pagesCount = itemsCount % itemsPerPage == 0 ?
      itemsCount / itemsPerPage : itemsCount / itemsPerPage + 1;
    this.itemsPerPage = itemsPerPage;
  }
  
  // Here I create methods which will return items and pages count.
  public int itemCount() { return itemsCount; }
  public int pageCount() { return pagesCount; }
  
  
  /*Method below will return -1 if passed number will be less than zero or bigger than total pages count because it is invalid 
   * if passed number will be within the pages count except last page it will return items per page since all pages are fully loaded except last
   * else statement will return modulo of items count divided by items per page.
   */
  public int pageItemCount(int pageIndex) {
    if(pageIndex < 0 || pageIndex > pagesCount-1) return -1;
    else if(pageIndex < pagesCount-1) return itemsPerPage;
    else return itemsCount % itemsPerPage;
  }
  /*Here I pass index of any item and if index is less than 0 or bigger than total items count 
   * which means invalid index it will return -1 as required in task requirements
   * Otherwise it will return item index divided by items per page which will return page index
   * */
  public int pageIndex(int itemIndex) {
    if(itemIndex < 0 || itemIndex > itemsCount-1) return -1;
    return itemIndex / itemsPerPage;
  }
}
