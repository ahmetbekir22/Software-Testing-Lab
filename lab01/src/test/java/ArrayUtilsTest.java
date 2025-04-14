
// import static org.junit.jupiter.api.Assertions.*;
// import org.junit.jupiter.api.Test;

// class ArrayUtilsTest {

//     // null array verildiğinde -1 dönmeli
//     @Test
//     void findLastIndex_nullArray_returnsNegativeOne() {
//         assertEquals(-1, ArrayUtils.findLastIndex(null, 5, 0));
//     }

//     // start index negatifse -1 dönmeli
//     @Test
//     void findLastIndex_negativeStart_returnsNegativeOne() {
//         assertEquals(-1, ArrayUtils.findLastIndex(new int[] { 1, 2, 3 }, 2, -1));
//     }

//     // start index, array uzunluğundan büyükse array.length olarak ayarlanmalı ve
//     // arama en sondan başlamalı
//     @Test
//     void findLastIndex_startBeyondLength_searchesFromEnd() {
//         int[] array = { 1, 2, 3, 2, 4 };
//         assertEquals(3, ArrayUtils.findLastIndex(array, 2, 10));
//     }

//     // aranan değer array'de varsa, en son bulunduğu index dönmeli
//     @Test
//     void findLastIndex_valuePresent_returnsLastIndex() {
//         int[] array = { 1, 2, 3, 2, 4 };
//         assertEquals(3, ArrayUtils.findLastIndex(array, 2, 4));
//     }

//     @Test
//     void findLastIndex_valueNotPresent_returnsNegativeOne() {
//         int[] array = { 1, 2, 3, 4 };
//         assertEquals(-1, ArrayUtils.findLastIndex(array, 5, 4));
//     }

//     @Test
//     void findLastIndex_searchFromMiddle_returnsLastIndexBeforeStart() {
//         int[] array = { 1, 2, 3, 2, 4 };
//         assertEquals(1, ArrayUtils.findLastIndex(array, 2, 3));
//     }

//     @Test
//     void findLastIndex_startEqualsArrayLength_validSearch() {
//         int[] array = { 1, 2, 3, 4, 2 };
//         assertEquals(4, ArrayUtils.findLastIndex(array, 2, 5));
//     }

//     @Test
//     void findLastIndex_startAtZero_returnsNegativeOne() {
//         int[] array = { 1, 2, 3, 4 };
//         assertEquals(-1, ArrayUtils.findLastIndex(array, 2, 0));
//     }

//     @Test
//     void findLastIndex_matchAtFirstIndexOnly() {
//         int[] array = { 9, 2, 3, 4 };
//         assertEquals(0, ArrayUtils.findLastIndex(array, 9, 1));
//     }

//     @Test
//     void findLastIndex_allSameElements() {
//         int[] array = { 5, 5, 5, 5 };
//         assertEquals(2, ArrayUtils.findLastIndex(array, 5, 3));
//     }

//     @Test
//     void findLastIndex_emptyArray_returnsNegativeOne() {
//         int[] array = {};
//         assertEquals(-1, ArrayUtils.findLastIndex(array, 5, 0));
//     }

//     @Test
//     void testMain_runsWithoutException() {
//         ArrayUtils.main(new String[] {});
//     }

//     @Test
//     void testConstructorCoverage() {
//         new ArrayUtils();
//     }

// }

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ArrayUtilsTest {

    // null array verildiğinde -1 dönmeli
    @Test
    void findLastIndex_nullArray_returnsNegativeOne() {
        assertEquals(-1, ArrayUtils.findLastIndex(null, 5, 0));
    }

    // negatif start index verilirse -1 dönmeli
    @Test
    void findLastIndex_negativeStart_returnsNegativeOne() {
        assertEquals(-1, ArrayUtils.findLastIndex(new int[] { 1, 2, 3 }, 2, -1));
    }

    // start index array uzunluğundan büyükse en sondan aranmalı
    @Test
    void findLastIndex_startBeyondLength_searchesFromEnd() {
        int[] array = { 1, 2, 3, 2, 4 };
        assertEquals(3, ArrayUtils.findLastIndex(array, 2, 10));
    }

    // start index array.length + 1 olduğunda doğru çalışmalı
    @Test
    void findLastIndex_startJustBeyondLength_adjustsProperly() {
        int[] array = { 1, 2, 3 };
        assertEquals(1, ArrayUtils.findLastIndex(array, 2, 4));
    }

    // start index tam array.length olduğunda çalışmalı
    @Test
    void findLastIndex_startEqualsLength_validSearch() {
        int[] array = { 1, 2, 3, 4, 2 };
        assertEquals(4, ArrayUtils.findLastIndex(array, 2, 5));
    }

    // start index sıfırsa -1 dönmeli
    @Test
    void findLastIndex_startAtZero_returnsNegativeOne() {
        int[] array = { 1, 2, 3, 4 };
        assertEquals(-1, ArrayUtils.findLastIndex(array, 2, 0));
    }

    // boş dizi verildiğinde -1 dönmeli
    @Test
    void findLastIndex_emptyArray_returnsNegativeOne() {
        int[] array = {};
        assertEquals(-1, ArrayUtils.findLastIndex(array, 1, 0));
    }

    // değer varsa ve birden fazla kez geçiyorsa, start'tan önceki sonuncusu dönmeli
    @Test
    void findLastIndex_valuePresent_returnsLastIndex() {
        int[] array = { 1, 2, 3, 2, 4 };
        assertEquals(3, ArrayUtils.findLastIndex(array, 2, 4));
    }

    // aranan değer dizide yoksa -1 dönmeli
    @Test
    void findLastIndex_valueNotPresent_returnsNegativeOne() {
        int[] array = { 1, 2, 3, 4 };
        assertEquals(-1, ArrayUtils.findLastIndex(array, 5, 4));
    }

    @Test
    void testMain_runsWithoutException() {
        ArrayUtils.main(new String[] {});
    }

    // döngü ortasından başlarsa ve eşleşme varsa doğru index dönmeli
    @Test
    void findLastIndex_searchFromMiddle_returnsLastIndexBeforeStart() {
        int[] array = { 1, 2, 3, 2, 4 };
        assertEquals(1, ArrayUtils.findLastIndex(array, 2, 3));
    }

    // eşleşme sadece ilk indexte varsa ve start onu kapsıyorsa doğru index dönmeli
    @Test
    void findLastIndex_matchAtFirstIndexOnly() {
        int[] array = { 9, 2, 3, 4 };
        assertEquals(0, ArrayUtils.findLastIndex(array, 9, 1));
    }

    // eşleşme sadece eşit olmayan değerlerle test edilmeli
    @Test
    void findLastIndex_similarButNotEqualValues_returnsNegativeOne() {
        int[] array = { 1, 1, 1 };
        assertEquals(-1, ArrayUtils.findLastIndex(array, 2, 3));
    }

    // tüm elemanlar aynıysa, start öncesi en sonuncusu dönmeli
    @Test
    void findLastIndex_allSameElements() {
        int[] array = { 5, 5, 5, 5 };
        assertEquals(2, ArrayUtils.findLastIndex(array, 5, 3));
    }

    // birden fazla eşleşme varsa start öncesi son eşleşen index dönmeli
    @Test
    void findLastIndex_multipleMatches_returnsLastBeforeStart() {
        int[] array = { 5, 6, 5, 6, 5 };
        assertEquals(2, ArrayUtils.findLastIndex(array, 5, 3));
    }

    // @Test
    // void findLastIndex_logsOutputCorrectly() {
    // // System.out.println satırlarını kontrol edemezsin ama çalışmasını garanti
    // // altına almak için testte çalıştırılmalı
    // assertDoesNotThrow(() -> ArrayUtils.main(new String[] {}));
    // }

    @Test
    void findLastIndex_withBoundaryValues() {
        int[] array = { Integer.MAX_VALUE, Integer.MIN_VALUE };
        assertEquals(0, ArrayUtils.findLastIndex(array, Integer.MAX_VALUE, 2));
        assertEquals(1, ArrayUtils.findLastIndex(array, Integer.MIN_VALUE, 2));
    }

    @Test
    void findLastIndex_singleElementOne_returnZero() {
        int[] array = { 1 };
        assertEquals(0, ArrayUtils.findLastIndex(array, 1, 1));
    }

    @Test
    void findLastIndex_forLoopBehaviour_test() {
        int[] array = { 9, 8, 7, 6 };
        assertEquals(2, ArrayUtils.findLastIndex(array, 7, 4));
    }

    @Test
    void findLastIndex_specificIndexValue_test() {
        int[] array = { 0, 1, 2, 3 };
        assertEquals(3, ArrayUtils.findLastIndex(array, 3, 4));
    }

    @Test
    void findLastIndex_matchAtStart_highStartIndex() {
        int[] array = { 5, 6, 7, 8 };
        assertEquals(0, ArrayUtils.findLastIndex(array, 5, 10));
    }

}
