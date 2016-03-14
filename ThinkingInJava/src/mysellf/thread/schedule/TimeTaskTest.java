package mysellf.thread.schedule;

import java.util.Timer;
import java.util.TimerTask;

public class TimeTaskTest {
	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new Task(timer), 3 * 1000);
		// final Timer timer = new Timer();
		// TimerTask task = new TimerTask() {
		// private int count;
		//
		// @Override
		// public void run() {
		// this.count++;
		// System.out.println(count);
		// if (count == 3) {
		// System.out.println("定时器停止了");
		// timer.cancel();// 停止定时器
		// }
		// }
		// };
		// timer.schedule(task, 0, 1000);// 1秒一次
	}
}

class Task extends TimerTask {

	private Timer timer = null;

	Task(Timer timer) {
		this.timer = timer;
	}

	public void run() {
		System.out.println("定时任务执行");
		this.timer.cancel();
	}
}