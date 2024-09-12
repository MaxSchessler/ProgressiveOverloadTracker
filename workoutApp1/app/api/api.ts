import AsyncStorage from "@react-native-async-storage/async-storage";
import axios, {AxiosError, AxiosInstance, AxiosResponse} from "axios";

const Api: AxiosInstance = axios.create({baseURL: "https://localhost:8080/api"});

Api.interceptors.request.use(async (config) => {
  const token = await AsyncStorage.getItem("token");
  if (token) {
    config.headers.Authorization = `Bearer ${token}`;
  }
  return config;
});

Api.interceptors.response.use(
    async (response: AxiosResponse) => response.data,
    async (error: AxiosError) => Promise.reject(error)

);

export {Api}