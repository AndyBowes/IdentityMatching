package alignment

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Unit Tests for the Calculation of the Levenshtein Distance and alignments
 *
 */
class LevenshteinTest {

    @Test fun testLevenshtein() {
        var result = levenshtein("smith", "smyth")
        assertEquals (1 , result.first)
        assertEquals ("smith" , result.second)
        assertEquals ("smyth" , result.third)
    }

    @Test fun testLevenshtein2() {
        val result = levenshtein("kittens", "sittin")
        assertEquals (3 , result.first )
        assertEquals ("kittens" , result.second)
        assertEquals ("sittin-" , result.third)
    }

    @Test fun testLevenshtein3() {
        val result = levenshtein("attcgccaggt", "aatcgcgatgg")
        assertEquals (4 , result.first )
        assertEquals ("attcgcca-ggt", result.second)
        assertEquals ("aatcgcgatgg-" , result.third)
    }

    @Test fun testLevenshtein4() {
        val result = levenshtein("TGTATGGACAGGCCACGTCTTGATTATCCACTCATCTGCTCCTGGACTTCTGGGTTGCTTCTACCATTTGCCCCTGTTGGGAAGAGTGCTCTGTATTCATACGGGTTTTTGTGTGGACACACGTTTCAATTCTCTTGGGTACACAGGCGTGGATGTGCAGGAGTCAGGGAAAAAAGCTCACTGGTGCCACTGGGCATCAAGCCCAGCTTCCTAGGCTGCGAATGGGCAGGTCTGCGGCCAGGACTCGTCTTCTTTTCCACGTGGGGCCCCTAGCTTGGCACCTAGCACGTGGC",
                "TGTACAGACAGGCCACTTTTTACCCACTCATCTGCTTCTGGACTTTTGGGTTGCTTCTACCATGTGGCCTGTTGGGAACAGTGCTCTGTTTGTATTCATGTACGGGTTTTTGTGTGGACACACATTTTCAAGTCTCTTGGGTACACAGGTGTAGAAGTGCCAGAGTTGGGGAAAAAGCTCACCTTTCTAGGCTGTGAATGGGCCCTGGCAAGTCTGTGGCCAGGACTCGTCTTCTCTTCCACATGGGGCCCCTAGCTTGGCACCTAGCACGTGGC")
        println(result.second)
        println(result.second.zip(result.third,{c1,c2 -> if (c1==c2) '|' else ' '}).joinToString(""))
        println(result.third)
        assertEquals (62 , result.first )
        assertEquals ("TGTATGGACAGGCCACGTCTTGATTATCCACTCATCTGCTCCTGGACTTCTGGGTTGCTTCTACCATTTGCCCCTGTTGGGAAGAGTGCTCTGT----ATTCAT--ACGGGTTTTTGTGTGGACACACGTTT-CAATTCTCTTGGGTACACAGGCGTGGATGTGC-AGGAGTCAGGGAAAAAAGCTCAC-TGGTGCCACTGGGCATCAAGCCCAGCTTCCTAGGCTGCGAATGGGCAGGTCTGCGGCCAGGACTCGTCTTCTTTTCCACGTGGGGCCCCTAGCTTGGCACCTAGCACGTGGC",
                     result.second)
        assertEquals ("TGTACAGACAGGCCAC-T-TT--TTACCCACTCATCTGCTTCTGGACTTTTGGGTTGCTTCTACCATGTGGCC-TGTTGGGAACAGTGCTCTGTTTGTATTCATGTACGGGTTTTTGTGTGGACACACATTTTCAAGTCTCTTGGGTACACAGGTGTAGAAGTGCCAG-AGTTGGGGAAAAA-GCTCACCTT-T-CTA--GG-C-TGT-GA--A--TG----GGCC-C---TGG-CAAGTCTGTGGCCAGGACTCGTCTTCTCTTCCACATGGGGCCCCTAGCTTGGCACCTAGCACGTGGC",
                     result.third)
    }

}
