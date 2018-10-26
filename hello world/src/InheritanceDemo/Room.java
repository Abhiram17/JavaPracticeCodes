package InheritanceDemo;

public class Room {
	int l,b;
	Room(int x,int y)
	{
		l=x;
		b=y;
	}
	void area() {
		int res;
		res=l*b;
		System.out.println("Area of room: "+res);
	}
}

class bedRoom extends Room
{
	int h;
	bedRoom(int x, int y) {
		super(x, y);
		h = 3;
	}
	void volume() {
		int res;
		res = l*b*h;
		System.out.println("Area of bed room: "+res);
	}
	
}

class RoomApp
{
	public static void main(String[] args) {
		bedRoom b = new bedRoom(10, 5);
		b.area();
		b.volume();
	}
}