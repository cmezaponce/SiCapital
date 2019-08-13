/* 
 * Proyecto SI CAPITAL
 * Secretaria de movilidad
 * Created on : 27/07/2019, 09:15:37 PM
 */

function soloNumeros(event) {
    var whichCode = event.which;
    return whichCode === 0 || whichCode === 8 || whichCode === 9
        || whichCode === 13 || whichCode === 16 || whichCode === 17
        || whichCode === 27 
        || (whichCode >= 48 && whichCode <= 57);
}

