package set;

import java.util.ArrayList;
import java.util.List;

public class HashSet extends Set {
	protected final int size = 5;
	protected ArrayList<ArrayList<Integer>> arr ;
	HashSet(){
		arr = new ArrayList<>();
			for(int index=0;index<this.size;index++) {
				arr.add(null);
			}
		}
	@Override
	public boolean empty() {
		ArrayList<Integer> subArr;
		for(int i =0; i< this.size;i++) {
			subArr = this.arr.get(i);
			if(subArr==null) {	
			}
			else {
				if (subArr.size()>0) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public boolean add(int value) {
		int index = value%this.size;
		if(!this.contains(value)) {
			ArrayList<Integer> subArr = this.arr.get(index);
			if(subArr==null) {
				ArrayList<Integer> newArr = new ArrayList<Integer>();
				newArr.add(value);
				this.arr.set(index, newArr);
				return true;
			}
			else {
				subArr.add(value);
				return true;
			}
		}
		
		else {
			return false;
		}
		
	}

	@Override
	public void remove(int value) {
		// TODO Auto-generated method stub
		int index = value%this.size;
		ArrayList<Integer> subArr; //= new ArrayList<Integer>();
		subArr = this.arr.get(index);
		if(subArr!=null) {
			subArr.remove(Integer.valueOf(value));
		}	
	}

	@Override
	public boolean contains(int value) {
		int index = value%this.size;
		ArrayList<Integer> subArr; //= new ArrayList<Integer>();
		subArr = this.arr.get(index);
		if(subArr!=null) {
			for (int i=0;i<subArr.size();i++) {
				if(value == subArr.get(i)){
					return true;
				}
			}
		}
		return false;
	}


	@Override
	public void clear() {
		// TODO Auto-generated method stub
		for (int index =0;index<this.size;index++) {
			this.arr.set(index, null);
		}
	}
	
}
