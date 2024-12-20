import java.util.Scanner;

public class ManajemenKafe {
    static Scanner sc = new Scanner(System.in);

    static void tambahPesanan(int[][] nomorMenuPelanggan, int[][] jumlahItemPelanggan, int[] hargaTotalPelanggan,
            int[] nomorMejaPelanggan, int[] counterMenuPelanggan, int[] hargaMenu, String[] namaPelanggan,
            String[] daftarMenu, int counterPelanggan) {
        System.out.print("Masukkan nama pelanggan: ");
        namaPelanggan[counterPelanggan] = sc.nextLine();
        System.out.print("Masukkan nomor meja: ");
        nomorMejaPelanggan[counterPelanggan] = sc.nextInt();

        cetakMenuKafe();

        int pilihanMenu;
        int counterMenu = 0;
        int jumlahItem = 0;

        while (true) {
            System.out.print("Pilih menu (masukkan nomor menu, atau 0 untuk selesai): ");
            pilihanMenu = sc.nextInt();

            if (pilihanMenu < 0 || pilihanMenu > daftarMenu.length) {
                System.out.println("Nomor menu tidak valid.");
            } else if (pilihanMenu != 0) {
                nomorMenuPelanggan[counterPelanggan][counterMenu] = pilihanMenu;
                while (true) {
                    System.out.print("Masukkan jumlah item untuk " + daftarMenu[pilihanMenu - 1] + ": ");
                    jumlahItem = sc.nextInt();

                    if (jumlahItem <= 0) {
                        System.out.println("Jumlah item hanya menerima nilai lebih dari 0");
                    } else {
                        jumlahItemPelanggan[counterPelanggan][counterMenu] = jumlahItem;
                        break;
                    }
                }
                System.out.println();
                counterMenu++;
            } else {
                break;
            }
        }

        for (int i = 0; i < counterMenu; i++) {
            int nomorMenu = nomorMenuPelanggan[counterPelanggan][i] - 1;
            hargaTotalPelanggan[counterPelanggan] += hargaMenu[nomorMenu]
                    * jumlahItemPelanggan[counterPelanggan][i];
        }

        counterMenuPelanggan[counterPelanggan] = counterMenu;

        System.out.println();
        System.out.println("Pesanan berhasil ditambahkan.");
        System.out.println("Total harga pesanan: Rp " + hargaTotalPelanggan[counterPelanggan]);
        System.out.println();
    }

    static void cetakMenuUtama() {
        System.out.println("===== MENU UTAMA =====");
        System.out.println("1. Tambahkan Pesanan");
        System.out.println("2. Tampilkan Daftar Pesanan");
        System.out.println("3. Keluar");
        System.out.print("Pilih menu: ");
    }

    static void cetakMenuKafe() {
        System.out.println();
        System.out.println("===== MENU KAFE =====");
        System.out.println("1. Kopi Hitam - Rp 15000");
        System.out.println("2. Latte - Rp 22000");
        System.out.println("3. Teh Tarik - Rp 12000");
        System.out.println("4. Mie Goreng - Rp 18000");
        System.out.println();
    }

    static void cetakSeluruhPesanan(int[][] nomorMenuPelanggan, int[][] jumlahItemPelanggan, int[] hargaMenu,
            int[] nomorMejaPelanggan, int[] counterMenuPelanggan, int[] hargaTotalPelanggan, String[] daftarMenu,
            String[] namaPelanggan, int counterPelanggan) {

        if (counterPelanggan == 0) {
            System.out.println("Belum ada pesanan, mohon tambahkan pesanan terlebih dahulu");
            System.out.println();
            return;
        }

        System.out.println("===== DAFTAR PESANAN =====");
        for (int i = 0; i < counterPelanggan; i++) {
            System.out.println("Nama Pelanggan: " + namaPelanggan[i]);
            System.out.println("Nomor Meja: " + nomorMejaPelanggan[i]);
            System.out.println("Detail Pesanan:");
            for (int j = 0; j < counterMenuPelanggan[i]; j++) {
                int nomorMenuTemp = nomorMenuPelanggan[i][j] - 1;
                int jumlahItemTemp = jumlahItemPelanggan[i][j];
                String menuTemp = daftarMenu[nomorMenuTemp];
                int hargaTemp = hargaMenu[nomorMenuTemp] * jumlahItemTemp;
                System.out.println(" - " + menuTemp + " x " + jumlahItemTemp + " = Rp " + hargaTemp);
            }
            System.out.println("Total Harga Pesanan: Rp " + hargaTotalPelanggan[i]);
            System.out.println("--------------------------");
        }
        System.out.println();
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
            cetakMenuUtama();
            menu = sc.nextInt();
            sc.nextLine();

            System.out.println();
            if (menu == 1) {
                tambahPesanan(nomorMenuPelanggan, jumlahItemPelanggan, hargaTotalPelanggan, nomorMejaPelanggan,
                        counterMenuPelanggan, hargaMenu, namaPelanggan, daftarMenu, counterPelanggan);
                counterPelanggan++;
            } else if (menu == 2) {
                cetakSeluruhPesanan(nomorMenuPelanggan, jumlahItemPelanggan, hargaMenu, nomorMejaPelanggan,
                        counterMenuPelanggan, hargaTotalPelanggan, daftarMenu, namaPelanggan, counterPelanggan);
            } else if (menu == 3) {
                break;
            } else {
                System.out.println("Menu tidak valid");
            }
        }

        sc.close();
    }
}
