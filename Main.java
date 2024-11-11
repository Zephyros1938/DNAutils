import java.lang.StringBuilder;

public class Main {
    public static void main(String[] args) {

        System.out.println(args.length);

        if(args.length <= 0){
            System.err.println("Valid DNA sequence must be provided.");
        }

        String inDNA = args[0];

        String groupID = "N/A";

        if(args.length >= 2){
            groupID = args[1];
        }

        StringBuilder strRNA = new StringBuilder();

        String outRNA = inDNA
                .replaceAll("A", "1")   // CONVERT A TO 1
                .replaceAll("C", "2")   // CONVERT C TO 2
                .replaceAll("G", "3")   // CONVERT G TO 3
                .replaceAll("T", "4")   // CONVERT T TO 4
                .replaceAll("1", "U")   // CONVERT 1 TO U
                .replaceAll("2", "G")   // CONVERT 2 TO G
                .replaceAll("3", "C")   // CONVERT 3 TO C
                .replaceAll("4", "A");  // CONVERT 4 TO A
        

        for (int i = 0; i < inDNA.length(); i++) {
            strRNA.append(inDNA.substring(i, i + 1).replaceAll("A", "1")
                    .replaceAll("C", "2")
                    .replaceAll("G", "3")
                    .replaceAll("T", "4")
                    .replaceAll("1", "U")
                    .replaceAll("2", "G")
                    .replaceAll("3", "C")
                    .replaceAll("4", "A"));
            if (i % 3 == 2) {
                strRNA.append(' ');
            }
        }

        String outProteinLetter = strRNA.toString()
                .replaceAll("(UUU|UUC)", "F")                   // Phe
                .replaceAll("(UUA|UUG|CUU|CUC|CUA|CUG)", "L")   // Leu
                .replaceAll("(AUU|AUC|AUA)", "I")               // Ile
                .replaceAll("AUG", "M")                         // Met
                .replaceAll("(GUU|GUC|GUA|GUG)", "V")           // Val
                .replaceAll("(UCU|UCC|UCA|UCG)", "S")           // Ser
                .replaceAll("(CCU|CCC|CCA|CCG)", "P")           // Pro
                .replaceAll("(ACU|ACC|ACA|ACG)", "T")           // Thr
                .replaceAll("(GCU|GCC|GCA|GCG)", "A")           // Ala
                .replaceAll("(UAU|UAC)", "Y")                   // Tyr
                .replaceAll("(CAU|CAC)", "H")                   // His
                .replaceAll("(CAA|CAG)", "Q")                   // Gln
                .replaceAll("(AAU|AAC)", "N")                   // Asn
                .replaceAll("(AAA|AAG)", "K")                   // Lys
                .replaceAll("(GAU|GAC)", "B")                   // Asp
                .replaceAll("(GAA|GAG)", "E")                   // Glu
                .replaceAll("(UGU|UGC)", "C")                   // Cys
                .replaceAll("UGG", "W")                         // Trp
                .replaceAll("(CGU|CGC|CGA|CGG|AGA|AGG)", "R")   // Arg
                .replaceAll("(AGU|AGC)", "S")                   // Ser
                .replaceAll("(GGU|GGC|GGA|GGG)", "G")           // Gly
                .replaceAll("(UAA|UAG|UGA)", "*");              // STOP
        
        String outProteinAbbr = strRNA.toString()
                .replaceAll("(UUU|UUC)", "PHE ")                   // Phe
                .replaceAll("(UUA|UUG|CUU|CUC|CUA|CUG)", "LEU ")   // Leu
                .replaceAll("(AUU|AUC|AUA)", "ILE ")               // Ile
                .replaceAll("AUG", "MET ")                         // Met
                .replaceAll("(GUU|GUC|GUA|GUG)", "VAL ")           // Val
                .replaceAll("(UCU|UCC|UCA|UCG)", "SER ")           // Ser
                .replaceAll("(CCU|CCC|CCA|CCG)", "PRO ")           // Pro
                .replaceAll("(ACU|ACC|ACA|ACG)", "THR ")           // Thr
                .replaceAll("(GCU|GCC|GCA|GCG)", "ALA ")           // Ala
                .replaceAll("(UAU|UAC)", "TYR ")                   // Tyr
                .replaceAll("(CAU|CAC)", "HIS ")                   // His
                .replaceAll("(CAA|CAG)", "GLN ")                   // Gln
                .replaceAll("(AAU|AAC)", "ASN ")                   // Asn
                .replaceAll("(AAA|AAG)", "LYS ")                   // Lys
                .replaceAll("(GAU|GAC)", "ASP ")                   // Asp
                .replaceAll("(GAA|GAG)", "GLU ")                   // Glu
                .replaceAll("(UGU|UGC)", "CYS ")                   // Cys
                .replaceAll("UGG", "TRP ")                         // Trp
                .replaceAll("(CGU|CGC|CGA|CGG|AGA|AGG)", "ARG ")   // Arg
                .replaceAll("(AGU|AGC)", "SER ")                   // Ser
                .replaceAll("(GGU|GGC|GGA|GGG)", "GLY ")           // Gly
                .replaceAll("(UAA|UAG|UGA)", "STOP ");             // STOP

        System.out.println("GROUP ID " + groupID + "\n------------------------------------------");
        System.out.println("DNA converted to RNA    :\n\t" + outRNA);
        System.out.println("Protein Abbriations     :\n\t" + outProteinAbbr);
        System.out.println("Protein Letters         :\n\t" + outProteinLetter.replaceAll(" ", "") + '\n');
    }
}