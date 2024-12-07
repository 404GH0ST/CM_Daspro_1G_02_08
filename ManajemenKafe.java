import java.util.Scanner;

public class ManajemenKafe {
    static Scanner sc = new Scanner(System.in);

    static void masukkanDataPelanggan(String[] namaPelanggan, int[] nomorMejaPelanggan, int counterPelanggan){
                System.out.print("Masukkan nama pelanggan: ");
                namaPelanggan[counterPelanggan] = sc.nextLine();
                System.out.print("Masukkan nomor meja: ");
                nomorMejaPelanggan[counterPelanggan] = sc.nextInt();
    }

    static int masukkanPesanan(int[][] nomorMenuPelanggan, int[][] jumlahItemPelanggan, String[] daftarMenu, int counterPelanggan){
                int pilihanMenu;
                int counterMenuTemp = 0;
                while (true) {
                    System.out.print("Pilih menu (masukkan nomor menu, atau 0 untuk selesai): ");
                    pilihanMenu = sc.nextInt();

                    if (pilihanMenu != 0) {
                        nomorMenuPelanggan[counterPelanggan][counterMenuTemp] = pilihanMenu;
                        System.out.print("Masukkan jumlah item untuk " + daftarMenu[pilihanMenu - 1] + ": ");
                        jumlahItemPelanggan[counterPelanggan][counterMenuTemp] = sc.nextInt();
                        System.out.println();
                        counterMenuTemp++;
                    } else {
                        break;
                    }
                }
                return counterMenuTemp;
    }

    static void hitungHargaTotal(int[][] nomorMenuPelanggan, int[][] jumlahItemPelanggan, int[]hargaTotalPelanggan, int[] hargaMenu, int[] counterMenuPelanggan, int counterMenu, int counterPelanggan){
                for (int i = 0; i < counterMenu; i++) {
                    int nomorMenu = nomorMenuPelanggan[counterPelanggan][i] - 1;
                    hargaTotalPelanggan[counterPelanggan] += hargaMenu[nomorMenu]
                            * jumlahItemPelanggan[counterPelanggan][i];
                }
                counterMenuPelanggan[counterPelanggan] = counterMenu;
    }

    public static void main(String[] args) {
        int[] hargaMenu = { 15_000, 22_000, 12_000, 18_000 };
        String[] daftarMenu = { "Kopi Hitam", "Latte", "Teh Tarik", "Mie Goreng" };
        String[] namaPelanggan = new String[50];
        int[] nomorMejaPelanggan = new int[50];
        int[][] nomorMenuPelanggan = new int[50][50];
        int[][] jumlahItemPelanggan = new int[50][50];
        int[] hargaTotalPelanggan = new int[50];
        int[] counterMenuPelanggan = new int[50];

        int menu;
        int counterPelanggan = 0;

        while (true) {
            System.out.println("===== MENU UTAMA =====");
            System.out.println("1. Tambahkan Pesanan");
            System.out.println("2. Tampilkan Daftar Pesanan");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");

            menu = sc.nextInt();
            sc.nextLine();

            System.out.println();
            if (menu == 1) {
                masukkanDataPelanggan(namaPelanggan, nomorMejaPelanggan, counterPelanggan);

                System.out.println();
                System.out.println("===== MENU KAFE =====");
                System.out.println("1. Kopi Hitam - Rp 15000");
                System.out.println("2. Latte - Rp 22000");
                System.out.println("3. Teh Tarik - Rp 12000");
                System.out.println("4. Mie Goreng - Rp 18000");
                System.out.println();

                int counterMenuTemp = masukkanPesanan(nomorMenuPelanggan, jumlahItemPelanggan, daftarMenu, counterPelanggan);
                hitungHargaTotal(nomorMenuPelanggan, jumlahItemPelanggan, hargaTotalPelanggan, hargaMenu, counterMenuPelanggan, counterMenuTemp, counterPelanggan);

                System.out.println();
                System.out.println("Pesanan berhasil ditambahkan.");
                System.out.println("Total harga pesanan: Rp " + hargaTotalPelanggan[counterPelanggan]);
                System.out.println();

                counterPelanggan++;
            } else if (menu == 2) {
                // TODO

            } else if (menu == 3) {
                break;
            } else {
                System.out.println("Menu tidak valid");
            }
        }

        sc.close();
    }
}
