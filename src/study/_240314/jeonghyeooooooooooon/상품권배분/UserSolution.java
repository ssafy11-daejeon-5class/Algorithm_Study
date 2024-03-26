package study._240314.jeonghyeooooooooooon.상품권배분;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class UserSolution {

	static HashMap<Integer, Dept> depts = new HashMap<>();
	static HashMap<Integer, Integer> roots = new HashMap<>();
	/*
	 * 
	 * 1000번 
	 * 
	 */
	
	public void init(int N, int mId[], int mNum[]) {
		Dept dept;
		for(int i = 0; i < mId.length; i++) {
			dept = new Dept(mId[i], mNum[i]);
			depts.put(mId[i], dept);
			
			putDeptIntoRoots(mId[i], mNum[i]);
		}		
		return;
	}
	
	public void putDeptIntoRoots(int mId, int peopleNum) {
		Dept dept = depts.get(mId);
		if(roots.containsKey(peopleNum)) {
			roots.put(peopleNum, roots.get(peopleNum) + 1);
			roots.get(peopleNum);
		}
		else {
			roots.put(peopleNum, new ArrayList<>());
			roots.get(peopleNum).add(dept);
		}
	}

	public int add(int mId, int mNum, int mParent) {
		if(depts.get(mParent).children.size() == 3) 
			return -1;
		Dept newDept = new Dept(mId, mNum, mParent);
		depts.get(mParent).children.add(newDept);
		while(depts.get(mId).parent != null) {
			Dept tempParent = depts.get(mId).parent;
			mId = tempParent.mId;
			tempParent.peopleNum += mNum;
		}
		
		return 0;
	}

	public int remove(int mId) {
		Dept temp = depts.get(mId);
		if(!depts.containsKey(mId))
			return -1;
		
		int deletedPeopleNum = temp.peopleNum;
		int anscestorId = minusPeopleNumOfParents(mId, deletedPeopleNum);
		putDeptIntoRoots(anscestorId, depts.get(anscestorId).peopleNum + deletedPeopleNum);
		removeDeptOfRoots(anscestorId);
		removeChildrenAndMe(mId);
		return deletedPeopleNum;
	}
	
	public void removeDeptOfRoots(int mId) {
		Dept dept = depts.get(mId);
		roots.get(dept.peopleNum).remove(dept);
	}
	
	public void removeChildrenAndMe(int mId) {
		Dept temp = depts.get(mId);
		int cnt = 0;
		for(int i = 0; i < temp.children.size(); i++) {
			depts.remove(temp.children.get(i).mId);
		}	
		depts.remove(temp.mId);
	}
	
	public int minusPeopleNumOfParents(int mId, int num) {
		if(depts.get(mId).parent == null) 
			return mId;
		Dept parent = depts.get(mId).parent;
		parent.peopleNum -= num;
		return minusPeopleNumOfParents(parent.mId, num);	
	}
	

	public int distribute(int K) {
		return 0;
		
		/*
		 * 상품권 개수 80만, 그룹 개수 1000
		 * 분배했던 걸 기록해두면 좋을듯
		 * 
		 * 방법 1. (상품권의 개수 이진탐색) 만큼 그룹에 분배해봄
		 * 
		 * 방법 2. (그룹 개수를 늘려가면서) 상품권 분배해봄
		 * 
		 */
	}
	
	
	static class Dept{
		int mId, peopleNum;
		Dept parent;
		List<Dept> children;
		
		public Dept() {
		}
		
		public Dept(int mId, int peopleNum) {
			this.mId = mId;
			this.peopleNum = peopleNum;
		}
		
		public Dept(int mId, int peopleNum, int parentId) {
			this.mId = mId;
			this.peopleNum = peopleNum;
			this.parent = depts.get(parentId);
		}
	}
}