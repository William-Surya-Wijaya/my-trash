// Lengkapi program untuk menghitung banyaknya solusi N-Queen yang mungkin.
//Bagian yang harus anda lengkapi ditandari dengan simbol komentar /* */
//

class NQueen{	 
	int N;				//dimensi papan
	int board[][];		//papan 
	int freecells[];	//nilai di setiap index: banyaknya baris yang masih kosong pada kolom ke-index
	//int queen[];		//nilai di setiap index: di baris keberapa queen ke-index ditempatkan
	int numSolution;	//banyaknya solusi

	public NQueen(int N){
		//inisialisasi atribut
		this.N = N;					
		this.board = new int[N][N];
		this.freecells = new int[N];
		//this.queen = new int[N];
	}

	// print isi papan, contoh:
	//	0 0 2 1 Q
	//	0 Q 1 2 2	
	//	0 1 2 Q 3
	//	Q 1 1 1 1
	//	0 1 Q 3 2
	public void printBoard(){
		int i,j;

		//lihat setiap kotak pada papan
		for(i=0; i<N; i++){
			for(j=0; j<N; j++)
				if(board[i][j] == -1)		// jika isinya -1, maka itu adalah Queen
					System.out.print("Q ");
				else						//selain itu, print isinya
					System.out.print(board[i][j] + " ");
			System.out.println("");			// ke baris berikutnya
		}
		System.out.println("");
	}

	/*
		Method untuk menghitung jumlah solusi yang mungkin
	*/
	public void generateSolution(){
		int i,j;	//counter
		
		// awalnya belum ada solusi sama sekali
		numSolution = 0;

		/*Inisialisasi papan. Seluruh kotak pada papan diisi dengan 0*/
		for (int k = 0; k < N; k++) {
			for (int l = 0; l < N; l++) {
				board[k][l] = 0;
			}
		}
		

		
		/*Inisialisasi isi dari freecells, banyaknya posisi yang masih 
		mungkin untuk ditempati di suatu kolom. Awalnya semua memiliki nilai N 
		*/

		for (int k = 0; k < N; k++) {
			freecells[k] = N;
		}



		/*Lakukan penempatan Quenn untuk kolom ke 0, coba dari baris 0 s.d. N-1
		Saat mencoba, variable numSolution akan diupdate jika solusi ditemukan
		*/

		for (int k = 0; k < N; k++) {
			placeQueen(0, 1);
		}


		//print banyaknya solusi yang mungkin ke layar
		System.out.println("Solution = "+numSolution);
	}

	
	/*
		Method untuk menempatkan Queen ke-col di posisi (col, row).
		Jika ini adalah Queen di kolom terakhir, maka solusi ditemukan
	*/
	private void placeQueen(int col, int row){
		int c,r;		//counter

		//simpan informasi di array queen: Queen ke-col ditempatkan di baris row
		//queen[col] = row;
		/*tempatkan Queen ke papan (Queen adalah angka -1)
		*/

		board[row][col] = -1;


		//base case, jika ini adalah kolom terakhir, berarti (salah satu) solusi ditemukan
		if(col == N-1){
			numSolution++; //jumlah solusi ditambah satu
			//printBoard();
		}
		//selain itu, tandai papan
		else{
			//diagonal kanan atas
			for(c=col+1, r=row-1; c<N && r>=0; c++, r--)
				if(board[r][c] == 0){ //jika posisi tersebut masih kosong
					board[r][c] = col+1;	//isi dengan col+1, berarti terancam oleh queen ke col (+1 agar queen pertama tidak 0) 
					freecells[c]--;			//kotak kosong di kolom tersebut berkurang satu
				}

			/*baris kanan
			*/

			while(true) {
				c = col;
				r = row;

				if (c < N && r < N) {
					break;
				}else {
					if (board[r][c] == c) {
						board[r][c] = 0;
						freecells[c]++;
					}
					c++;
					r++;
				}
			}



			/*diagonal kanan bawah
			*/



			boolean flag = true; //true jika masih mungkin menempatkan Queen di semua kolom selanjutnya
			
			/*cek free cell di "depan", apakah masih ada kotak kosong untuk kolom-kolom selanjutnya?
			jika ada satu kolom yang 0, berarti tidak mungkin menempatan queen di kolom tersebut
			*/

			for (int i = c + 1; i < N; i++) {
				c++;

				if (freecells[c]==0) {
					flag = false;
					break;
				}
			}



			/*lanjutkan jika masih mungkin.
			untuk kolom berikutnya, coba peempatan Queen di baris yang masih kosong
			(penempatan menggunakan method placeQueen juga, berarti ada rekursif di sini)
			*/

			if (flag) {
				for (int i = 0; i < N; i++) {
					if (board[i][col + 1] == 0) {
						placeQueen(col + 1, r);
					}
				}
			}


			//backtracking di sini. hapus penanda di board
			/*untuk posisi diagonal kanan atas
			*/

			while(true) {
				c = col;
				r = row;

				if (c < N && r < N) {
					break;
				}else {
					if (board[r][c] == c) {
						board[r][c] = 0;
						freecells[c]++;
					}
					c++;
					r++;
				}
			}
			
			
			
			/*baris kanan
			*/

			while(true) {
				c = col;
				r = row;

				if (c < N && r < N) {
					break;
				}else {
					if (board[r][c] == c) {
						board[r][c] = 0;
						freecells[c]++;
					}
					c++;
					r++;
				}
			}



			/*diagonal kanan bawah
			*/

			while(true) {
				c = col;
				r = row;

				if (c < N && r < N) {
					break;
				}else {
					if (board[r][c] == c) {
						board[r][c] = 0;
						freecells[c]++;
					}
					c++;
					r++;
				}
			}


		}
				
		/*kosongkan kembali kotak (row, col)
		*/

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = 0;
			}
		}

	}
}

class NQueenTester2{
	public static void main(String[] args){
		//sesuaikan bagian ini dengan deskripsi tugas di bagian bawah
		
		NQueen nq = new NQueen(5); //Membuat papan berukuran 5x5
		nq.generateSolution();		//hitung banyaknya solusi untuk papan tersebut

	}
}


/* Deskripsi untuk tugas modul backtracking:
Carilah banyaknya solusi yang mungkin untuk kasus N-Queen

Masukan diawali dengan sebuah bilang r yang menyatakan banyaknya tes kasus
Setiap tes kasus terdiri dari sebuah bilangan bulat positif n yang lebih kecil dari 15

Keluaran: untuk setiap tes kasus, tampilkan banyaknya solusi yang mungkin dengan format:
Solution = ......


*/