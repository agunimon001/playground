def Decrypt(privatekey, N, encrypted):
    length = len(str(N))
    encrypted_length = len(str(encrypted))
    message_length = (encrypted_length // length)
    message = message_length * [""]

    encrypted = list(str(encrypted))

    for i in range(message_length):
        for j in range(i*length, (i+1)*length):
            message[i] += str(encrypted[j])

        message[i] = int(message[i])**privatekey%N
        message[i] = chr(message[i])

    message = ''.join(message)

    return message

def Encrypt(publickey, N):
    message = list(input("Enter message: "))

    mes = ""

    for a in range(len(message)):
        message[a] = str(ord(message[a]) ** publickey % N)

        if len(message[a]) < len(str(N)):
            message[a] = (len(str(N)) - len(message[a]))*'0' + message[a]

        mes += (message[a])

    return mes

def Keys(p,q):
    N = p*q
    E = (p-1)*(q-1)

    print("N: ", N)

    from fractions import gcd

    
    for k in range(2,E):
        if gcd(k,E) == 1:
            print("Public key: ", k)
            publickey = k
            break

    for v in range(2,E):
        if (v*publickey)%E == 1:
            print("Private key: ", v)
            privatekey = v
            break
            
    return N, publickey, privatekey
