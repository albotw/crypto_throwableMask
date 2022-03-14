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
        int output = 0;
        for (int filter : filters) {
            output = (int) (output ^ (this.buffer >> (filter - 1) & 1));
        }

        this.buffer = (this.buffer >> 1) | (long) output << this.length - 1;
        return output;
    }

    public int cycleByte() {
        int output = 0;
        for (int i = 0; i < 8; i++){
            int temp = cycle();
            output = (byte) ((output << 1) | temp);
        }

        return output;
    }
}
