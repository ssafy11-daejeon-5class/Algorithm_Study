package study._240314.jeonghyeooooooooooon;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
public class Test {
	public static void main(String[] args) {
		
		HashSet<Point> pointSet = new HashSet<>();

		pointSet.add(new Point(1, 1, "하이"));
		pointSet.add(new Point(1, 1, "하이"));
		
		for(int i = 0; i < pointSet.size(); i++) {
			
		}
		System.out.println(pointSet);
		
		
	}
	static class Point{
		int r, c;
		String name;
		
		
		
		public Point(int r, int c, String name) {
			super();
			this.r = r;
			this.c = c;
			this.name = name;
		}
		
		



		@Override
		public int hashCode() {
			return Objects.hash(c, name, r);
		}





		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			return c == other.c && Objects.equals(name, other.name) && r == other.r;
		}





		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", name=" + name + "]";
		}
		
	}
}
