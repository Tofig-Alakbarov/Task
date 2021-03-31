package Tofig;

import java.util.ArrayList;
import java.util.List;

public class TestHelper<T> {

	
		public static void main(String[] args) {
			List <Character> list = new ArrayList<Character>();
		list.add('a');
		list.add('b');
		list.add('c');
		list.add('d');
		list.add('e');
		list.add('f');
		
	PaginationHelper helper = new PaginationHelper(list, 4);
	System.out.println(helper.pageCount());
	System.out.println(helper.pageIndex(3));
	System.out.println(helper.itemCount());
	System.out.println(helper.pageItemCount(1));

		}
		
	

}
