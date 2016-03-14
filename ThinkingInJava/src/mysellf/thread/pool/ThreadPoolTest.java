package mysellf.thread.pool;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import org.productivity.java.syslog4j.server.impl.net.udp.UDPNetSyslogServer;

public class ThreadPoolTest extends UDPNetSyslogServer {

	public static void main(String[] args) {
		InetAddress add;
		try {
			add = InetAddress.getByName("192.168.1.160");
			DatagramSocket dataSocket = new DatagramSocket(514, add);
			byte[] by = new byte[1024];
			DatagramPacket dataPacket = new DatagramPacket(by, 1024);
			dataSocket.receive(dataPacket);
			byte[] bye = dataPacket.getData();
			String str = new String(bye);
			System.out.println(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	// 1.获取信息
	// 2.创建线程池进行解析信息

}
