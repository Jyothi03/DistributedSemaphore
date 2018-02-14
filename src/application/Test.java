package application;

import distributedsemaphor.DistributedSemaphore;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

public class Test {

	static DistributedSemaphore sem1;
	static DistributedSemaphore sem2;
	static DistributedSemaphore sem3;
	static DistributedSemaphore sem4;

	public static void main(String[] args) {
		try {
			 //testTwoNodesActive();
			 testFourActiveNodes();
		} catch (IOException ex) {
			System.err.println("ERROR: " + ex.getMessage());
			Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	

//public static void testTwoNodesActive() throws IOException {
//		try {
//		Thread one = new Thread() {
//
//				public void run() {
//					try {
//						String[][] config1 = { { "137.30.121.228", "5002" }, { "137.30.121.227", "5001" } };
//						sem1 = new DistributedSemaphore("test1", config1);
//					} catch (IOException ex) {
//						System.err.println("ERROR: " + ex.getMessage());
//						Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//					}
//				}
//			};

	//		Thread two = new Thread() {

	//			public void run() {
	//				try {
	//					String[][] config2 = { { "localhost", "5005" }, { "137.30.121.225", "5003" } };
	//					sem2 = new DistributedSemaphore("test2", config2);
	//				} catch (IOException ex) {
	//					System.err.println("ERROR: " + ex.getMessage());
	//					Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
	//				}
	//			}
	//		};

//			one.start();
   //  		two.start();

	//		//one.join();
	//		two.join();

	//		System.out.println("acquire 1");
	//		sem2.P();
	//		sem2.V();
	//		System.out.println("release");

		//	//Thread.currentThread().sleep(1000);



			//System.out.println("acquire 3");
	//		sem2.P();
		//	sem2.V();
		//	System.out.println("release");

		//	//Thread.currentThread().sleep(1000);

		

		//	System.out.println("acquire 5");
		//	sem2.P();
		//	sem2.V();
		//	System.out.println("release");

		//	//Thread.currentThread().sleep(1000);

			

		//	System.out.println("acquire 7");
		//	sem2.P();
		//	sem2.V();
		//	System.out.println("release");

		//	//Thread.currentThread().sleep(1000);

			

		//	//sem1.close();
		//	sem2.close();

		//	System.out.println("END OF TWO NODE TEST");
	//	} catch (InterruptedException ex) {
		//	System.err.println("ERROR: " + ex.getMessage());
			//Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
		//}

	//}

	

	public static void testFourActiveNodes() throws IOException {
		try {
////			Thread one = new Thread() {
////
////				public void run() {
////					try {
////						//String[][] config1 = { { "137.30.121.227", "5003" }, { "137.30.121.227", "5002" },
////								//{ "137.30.121.228", "5003" }, { "137.30.121.228", "5004" } };
////						String[][] config1 = { { "137.30.121.222", "5001" },{ "137.30.121.221", "5002" }};
////						sem1 = new DistributedSemaphore("test1", config1);
////					} catch (IOException ex) {
////						System.err.println("ERROR: " + ex.getMessage());
////						Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
////					}
////				}
////			};
//
//			/*Thread two = new Thread() {
//
//				public void run() {
//					try {
//						String[][] config2 = { { "137.30.121.227", "5002" }, { "137.30.121.227", "5001" },
//								{ "137.30.121.228", "5003" }, { "137.30.121.228", "5004" } };
//						sem2 = new DistributedSemaphore("test2", config2);
//					} catch (IOException ex) {
//						System.err.println("ERROR: " + ex.getMessage());
//						Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//					}
//				}
//			};*/
//
//			Thread three = new Thread() {
//
//				public void run() {
//					try {
//						String[][] config2 = { { "137.30.121.228", "5003" }, { "137.30.121.227", "5001" },
//								{ "137.30.121.227", "5002" }, { "137.30.121.228", "5004" } };
//						sem3 = new DistributedSemaphore("test3", config2);
//					} catch (IOException ex) {
//						System.err.println("ERROR: " + ex.getMessage());
//						Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//					}
//				}
//			};

			Thread four = new Thread() {

				public void run() {
					try {
						String[][] config2 = { { "137.30.121.226", "5002" }, { "137.30.121.227", "5001" },
								{ "137.30.121.225", "5004" }, { "137.30.121.228", "5003" } };
						sem4 = new DistributedSemaphore("test4", config2);
					} catch (IOException ex) {
						System.err.println("ERROR: " + ex.getMessage());
						Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
					}
				}
			};

			//one.start();
			//two.start();
//			three.start();
			four.start();

			//one.join();
			//two.join();
//			three.join();
			four.join();

			System.out.println("acquire 3");
			sem3.P();
			sem3.V();
			System.out.println("release");
//
			//Thread.currentThread().sleep(1000);

			System.out.println("acquire 4");
			sem4.P();
			sem4.V();
			System.out.println("release");

//			Thread.currentThread().sleep(1000);

			System.out.println("acquire 3");
			sem4.P();
			sem4.V();
			System.out.println("release");

//			Thread.currentThread().sleep(1000);

			System.out.println("acquire 4");
			sem2.P();
			sem2.V();
//			System.out.println("release");

//			Thread.currentThread().sleep(1000);

			System.out.println("acquire 5");
			sem1.P();
			sem1.V();
			System.out.println("release");

//			Thread.currentThread().sleep(1000);

			System.out.println("acquire 6");
			sem3.P();
			sem3.V();
			System.out.println("release");

//			Thread.currentThread().sleep(1000);

			System.out.println("acquire 7");
			sem4.P();
			sem4.V();
			System.out.println("release");

//			Thread.currentThread().sleep(1000);

			System.out.println("acquire 8");
			sem2.P();
			sem2.V();
			System.out.println("release");

//			Thread.currentThread().sleep(1000);

			System.out.println("acquire 9");
			sem2.P();
			sem2.V();
			System.out.println("release");

//			Thread.currentThread().sleep(1000);

			System.out.println("acquire 10");
			sem1.P();
			sem1.V();
//			System.out.println("release");

	//		Thread.currentThread().sleep(1000);

			System.out.println("acquire 11");
			sem3.P();
			sem3.V();
			System.out.println("release");

//			Thread.currentThread().sleep(1000);

			System.out.println("acquire 12");
			sem4.P();
			sem4.V();
			System.out.println("release");

//			Thread.currentThread().sleep(1000);

			//sem1.close();
			//sem2.close();
//			sem3.close();
			sem4.close();

			System.out.println("END OF FOUR NODE TEST");
			System.out.println("------------------------------------------");
			System.out.println();
		} catch (InterruptedException ex) {
			Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
}
