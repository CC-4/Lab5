import csv

def main():

    programa = '''import utils.Accept;
import utils.Shift;
import utils.Reduce;
import utils.GoTo;

public final class ParseTable {

    // Para devolver un error
    private static boolean e() {
        return false;
    }

    // Para aceptar
    private static Accept ok() {
        return new Accept();
    }

    // Para crear un SHIFT
    private static Shift s(int s) {
        return new Shift(s);
    }

    // Para crear un REDUCE
    private static Reduce r(int p) {
        return new Reduce(p);
    }

    // Para crear un GoTo
    private static GoTo g(int s) {
        return new GoTo(s);
    }\n

    // Tabla de parseo generada
'''

    tab = '    '

    programa += tab + 'public static final Object[][] T = {\n'
    programa += tab + '//      ;     +     -     *     /     %     ^   SIN   COS   TAN   (      )     id    $    S     E     T     P     F     A\n'
    reader = csv.reader(open('table.csv', 'r'), delimiter=',')
    reader.next()
    reader.next()
    reader.next()

    for n, line in enumerate(reader):

        programa += tab + tab + '{'
        for i in xrange(2, len(line)):
            entry = line[i].lower()

            if entry == '' and i < 16:
                programa += 'e()'.ljust(5)
            elif entry == '' and i > 15:
                programa += 'null'.ljust(5)
            elif entry.startswith('s(') and i < 16:
                programa += entry.ljust(5)
            elif entry.startswith('r(') and i < 16:
                programa += entry.ljust(5)
            elif entry.startswith('ok') and i < 16:
                programa += 'ok()'.ljust(5)
            elif entry.startswith('g(') and i > 15:
                programa += entry.ljust(5)
            else:
                print(entry)
                print(i)
                raise ValueError()

            if i != len(line) - 1:
                programa += ','
            else:
                programa += '}'

        if n < 28:
            programa += ', // S{0}\n'.format(n)
        else:
            programa += '  // S{0}\n'.format(n)

    programa += tab + '};\n\n}'


    f = open('ParseTable.java', 'w')
    f.write(programa)
    f.close()

if __name__ == '__main__':
    main()
