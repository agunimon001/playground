def Crack(publickey, N):
    for i in range(2,N):
        if N%i == 0:
            p,q = i, N//i
            break

    E = (p-1)*(q-1)

    for v in range(2,E):
        if (v*publickey)%E == 1:
            print("Private key: ", v)
            Decrypted_privatekey = v
            break

    return Decrypted_privatekey
