public class LFSR {
    private int[] filters;
    private long buffer;
    private int length;

    public LFSR(int[] filters, long initValue) {
        this.filters = filters;
        this.buffer = initValue;
        this.length = this.filters[this.filters.length - 1];
    }

    //retourne 1 bit
    public int cycle() {
        long xor = 0;
        for (int filter : filters) {
            xor =  xor ^ ((this.buffer >> (filter - 1)) & 1);
        }

        // récupère le 1er bit
        int output = (int) this.buffer & 1;
        // supprime le 1er bit du buffer et écrit le xor en bout de LFSR (pas du buffer)
        this.buffer = (this.buffer >> 1) | (xor << (this.length - 1));
        return output;
    }

    //retourne 8 bits
    public int cycleByte() {
        int output = 0;
        for (int i = 0; i < 8; i++){
            int temp = cycle();
            output = (output << 1) | temp;
            //System.out.println("temp: " + temp + " | output: " + output);
        }

        return output;
    }
}
