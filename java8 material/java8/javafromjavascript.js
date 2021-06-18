var BigDecim al = Java.type('java.math.BigDecimal');
function calculate(am ount, percentage) {
var result = new BigDecim al(am ount).m ultiply(
new BigDecim al(percentage)).divide(new BigDecim al("100"), 2,
BigDecim al.ROUND_HALF_EVEN);
return result.toPlainString();
}
var result = calculate(568000000000000000023,13.9);
print(result);